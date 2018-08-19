/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LabRole;
import Business.Role.Role;
import Business.Role.remoteClinicAdminRole;
import Business.Role.remoteClinicManagerRole;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class remoteClinicManagerOrganization extends Organization {

       public remoteClinicManagerOrganization (){
        super(Organization.Type.remoteClinicTravelManager.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new remoteClinicManagerRole());
         return roles;
    }
    
}
