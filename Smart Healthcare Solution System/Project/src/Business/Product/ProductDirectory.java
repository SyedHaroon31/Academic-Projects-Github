/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import java.util.ArrayList;

/**
 *
 * @author Ashish
 */
public class ProductDirectory {
        private ArrayList<Product> productList;

    public ProductDirectory() {
        productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public Product addProduct(Product.ProductType type){
        Product p = new Product(type);
        productList.add(p);
        return p;
    }
    
    public void removeProduct(Product p){
        productList.remove(p);
    }
    
    public Product searchProduct(int id){
        for (Product product : productList) {
            if(product.getProductId()==id){
                return product;
            }
        }
        return null;
    }    
    public int getAvailabileQuantity(Product p)
    {
        for(Product prod:productList)
        {
            if(prod.equals(p))
            {
                return prod.getProductQuantity();
            }
        }
        return 0;
    }
    public void setUpdatedQuantity(Product p,int newQuantity)
    {
        for(Product prod:productList)
        {
            if(prod.equals(p))
            {
                prod.setProductQuantity(newQuantity);
            }
        }
    }
}
