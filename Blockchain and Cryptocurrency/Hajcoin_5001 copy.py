
#Module 1 - Create a CryptoCurrency

#To be installed:
#FLask=0.12.2: pip install Flask==0.12.2
#Postman HTTP client:http://www/getpostman.com/

#additional library --> requests == 2.18.4

#import the library

import datetime                   #each block will have its own timestamp
import hashlib                    #to hash blocks
import json                       #use dumps to encode blocks before hashing them
from flask import Flask, jsonify , request  
                                            #Flask class - web application jsonify: to return and post messages , 
                                            # requests is added because of nodes in blockchain and communication between them
from uuid import uuid4                #it generates a unique address
from urllib.parse import urlparse   #it is used to parse the address(i.p) from URL
import requests                    #it is used to get the consensus from the nodes


#Part-1:Building a Blockchain

class Blockchain:
    
    def __init__(self):
        self.chain = []
        self.transactions = []                              #has to be created before the create_block(next line) - cas transacation within create_block need a value to search
        self.create_block(proof = 1, previous_hash = '0')
        self.nodes = set() 
        
    def create_block(self, proof, previous_hash):
        block = {'index':len(self.chain)+1, 
                     'timestamp': str(datetime.datetime.now()),
                     'proof' : proof,
                     'previous_hash': previous_hash,
                     'transactions' : self.transactions
                     }
        
        self.transactions = []
        self.chain.append(block)
        return block
    
    def get_previous_block(self):
        return self.chain[-1]
#proof work is the number or piece of data that the miners have to find 
#in order to mine a new block(basically a specific number)
#its hard to find but easy to verify
        
    def proof_of_work(self, previous_proof):
        new_proof = 1   # is initalised one and keeps icrementing after looping to get right proof
        check_proof = False  #check if its right proof
        while check_proof is False:
            #below is the problems the miners need to solve, soln: it needs to have 4 leading 0's
            #the hash operation should be non-symmetrical
            hash_operation = hashlib.sha256(str(new_proof**2 - previous_proof**2).encode()).hexdigest()
            if hash_operation[:4] == '0000':
                check_proof = True
            else:
                new_proof += 1
        return new_proof
         
    def hash(self, block):
        #dumps is used to convert block dictionary to string 
        encoded_block = json.dumps(block,sort_keys = True).encode()
        return hashlib.sha256(encoded_block).hexdigest()
    
    def is_chain_valid(self,chain):
        previous_block = chain[0]
        block_index = 1
        while block_index < len(chain):
            block = chain[block_index]
            if block['previous_hash'] != self.hash(previous_block):
                return False
            previous_proof = previous_block['proof']
            new_proof = block['proof']
            hash_operation = hashlib.sha256(str(new_proof**2 - previous_proof**2).encode()).hexdigest()
            if hash_operation[:4] != '0000':    
                return False
            previous_block = block
            block_index += 1
        return True
    
    def add_transaction(self,sender, receiver, amount):
        self.transactions.append({'sender':sender,
                                  'receiver':receiver,
                                  'amount':amount})
        previous_block = self.get_previous_block()
        return previous_block['index']+1
        
    def add_node(self,address):
        parsed_url = urlparse(address)
        self.nodes.add(parsed_url.netloc)
        
    def replace_chain(self):
        network = self.nodes
        longest_chain = None
        max_length = len(self.chain)
        for node in network:
            response = requests.get(f'http://{node}/get_chain')      # f'http://{node}/get_chain' is same as  'http://127.0.0.1:5000/get_chain' 
            if response.status_code == 200:
                length = response.json()['length']
                chain = response.json()['chain']
                if length > max_length and self.is_chain_valid(chain):
                    max_length = length
                    longest_chain = chain
        if longest_chain:                                           # mean if longest_chain is not none
            self.chain = longest_chain
            return True
        return False
           
    

#Part-2 : Mining the Blockchain
        
#Creating a Web App

app = Flask(__name__)


#Creating a address for the node on port 5000
node_address = str(uuid4()).replace('-','')



    
#Creating a blockchain
blockchain = Blockchain()
@app.route('/mine_block',methods=['GET'])
def mine_block():
    previous_block = blockchain.get_previous_block()
    previous_proof = previous_block['proof']
    proof = blockchain.proof_of_work(previous_proof)
    previous_hash = blockchain.hash(previous_block)
    blockchain.add_transaction(sender = node_address, receiver = 'Hadeling', amount = 10)
    block = blockchain.create_block(proof, previous_hash)
    response = {'message': 'Congratulations, you just mined a block!',
                'index': block['index'],
                'timestamp': block['timestamp'],
                'proof': block['proof'],
                'previous_hash': block['previous_hash'],
                'transactions': block['transactions'] }
    return jsonify(response), 200

# Getting the full Blockchain
@app.route('/get_chain', methods = ['GET'])
def get_chain():
    response = {'chain': blockchain.chain,
                'length': len(blockchain.chain)}
    return jsonify(response), 200

#check if blockchain is valid
@app.route('/is_valid', methods = ['GET'])
def is_valid():
    is_valid = blockchain.is_chain_valid(blockchain.chain)
    if is_valid:
        response = {'message' : 'Blockchain is valid' }
    else:
        response = {'message' : 'Error.. We have a problem'}
    return jsonify(response), 200

#Adding a new transaction to blockchain
@app.route('/add_transaction', methods = ['POST'])     
def add_transaction():
    json = request.get_json()
    transaction_keys = ['sender','receiver','amount']
    if not all(key in json for key in transaction_keys):
        return 'Some elements in transaction is missing' , 400
    index = blockchain.add_transaction(json['sender'],json['receiver'],json['amount'])
    response = {'message' : f'This request is going to blocked {index}'}
    return jsonify(response), 201    
    

#Part-3: Decentralising Blockchain

#Connection new nodes
@app.route('/connect_node', methods = ['POST'])   
def connect_node():
    json = request.get_json()
    nodes = json.get('nodes')
    if nodes is None:
        return 'No Node' , 400
    for node in nodes:
        blockchain.add_node(node)
    response = {'message':"All nodes are now connected. Hajcoin has these nodes",
                'total_nodes':list(blockchain.nodes)}
    return jsonify(response), 201

#Replacing the chain by the longest chain(correct chain) if needed
@app.route('/replace_chain', methods = ['GET'])
def replace_chain():
    is_chain_replaced = blockchain.replace_chain()
    if is_chain_replaced:
         response = {'message' : 'The chain has been replaced as the nodes had different chains',
                     'new_chain' : blockchain.chain}
         
    else:
        response = {'message' : 'The chain has not been replaced',
                    'actual_chain':blockchain.chain}
    return jsonify(response), 200



    
    
    
        
        
 
 
    
#Running an app
app.run(host='0.0.0.0',port = 5001)
        
            
            

















