/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.InventoryManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.util.HashSet;
import javax.swing.JPanel;
import userinterface.Hospital.HospitalAdminWorkAreaJPanel;
import userinterface.InventoryManager.InventoryManagerWorkArea;

/**
 *
 * @author haroonperveez
 */
public class InventoryManager extends Role{

   

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new InventoryManagerWorkArea(userProcessContainer, enterprise,account, (InventoryManagerOrganization) organization);
    }
    
   

 
}
