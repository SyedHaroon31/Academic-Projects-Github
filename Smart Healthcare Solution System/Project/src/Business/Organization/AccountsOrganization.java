/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GovernmentAccountManager;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author Ashish
 */
public class AccountsOrganization extends Organization {

      public AccountsOrganization() {
        super(Organization.Type.Accounts.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new GovernmentAccountManager() );
         return roles;
    }
    
}
