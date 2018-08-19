/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Citizen;
import Business.Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author haroonperveez
 */
public class CitizenDirectory {
    
    private ArrayList<Citizen> citizenList;
 
    
    public CitizenDirectory(){
        citizenList = new ArrayList<>();
    }

    public ArrayList<Citizen> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(ArrayList<Citizen> citizenList) {
        this.citizenList = citizenList;
    }
    public Citizen addCitizen(){
        Citizen citizen = new Citizen();
        citizen.setCid(citizenList.size()+1);
        citizenList.add(citizen);
        return citizen;
    }
    public Citizen authenticateCitizen(String username, String password){
        
        for (Citizen ua : citizenList)
        {
            if (ua.getUserId().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        }
        return null; 
    }
    
     public Citizen searchCitizen(int id){
        for(Citizen citizen : citizenList){
            if(citizen.getCid()==id){
                return citizen;
            }
        
        }
        return null;
    }
}


