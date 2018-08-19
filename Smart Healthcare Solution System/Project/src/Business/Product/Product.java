/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import java.util.Date;

/**
 *
 * @author Ashish
 */
public class Product {
    private int productId;
    private String productName;
    private int productQuantity;
    private String productModelNo;
    private int productPrice;
    private ProductType productType;
    private static int count =0;
    private Date lastUpdateDate;
    
    public enum ProductType{
        LabEquipment("Lab Equipment"),Other("Other");
        private String value;
        private ProductType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Product(ProductType type)
    {
        ++count;
        this.productId = count;
        this.productType=type;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductModelNo() {
        return productModelNo;
    }

    public void setProductModelNo(String productModelNo) {
        this.productModelNo = productModelNo;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    
        @Override
    public String toString() {
        return productName;
    }
}
