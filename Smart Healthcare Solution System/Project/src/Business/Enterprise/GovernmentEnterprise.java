/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.GovernmentAccountManager;
import Business.Role.MayorRole;
import Business.Role.Role;
import Business.Role.TreasurerRole;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class GovernmentEnterprise extends Enterprise {

    public GovernmentEnterprise(String name){
        
        super(name, EnterpriseType.Government);
    
    }
    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new MayorRole());
        roles.add(new TreasurerRole());
        roles.add(new GovernmentAccountManager());
        return roles;
    }
    
}
