/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CitizenRole;
import Business.Role.PublicSectorAdmin;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class CitizenOrganization extends Organization {
    
      public CitizenOrganization(){
        super(Organization.Type.Citizen.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new CitizenRole());
         
         return roles;
    
    }
    

}
