/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LabRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class LabOrganization extends Organization {
    
    public LabOrganization (){
        super(Organization.Type.Lab.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new LabRole());
         return roles;
    }
    
}
