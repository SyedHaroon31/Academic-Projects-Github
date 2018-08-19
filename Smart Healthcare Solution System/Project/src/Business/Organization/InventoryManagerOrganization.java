/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Product.ProductDirectory;
import Business.Role.DoctorRole;
import Business.Role.InventoryManager;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class InventoryManagerOrganization extends Organization{
    
    private ProductDirectory productDirectory;
    public InventoryManagerOrganization(){
        super(Organization.Type.InventoryManager.getValue());
        productDirectory=new ProductDirectory();
    }

    public ProductDirectory getProductDirectory() {
        return productDirectory;
    }

    
    
    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new InventoryManager());
         return roles;
    }
    
}
