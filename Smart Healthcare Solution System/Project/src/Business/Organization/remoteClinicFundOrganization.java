/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.remoteClinicAccountManager;
import Business.Role.remoteClinicManagerRole;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class remoteClinicFundOrganization extends Organization {

         public remoteClinicFundOrganization (){
        super(Organization.Type.remoteClinicAccountManager.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new remoteClinicAccountManager());
         return roles;
    }
}
