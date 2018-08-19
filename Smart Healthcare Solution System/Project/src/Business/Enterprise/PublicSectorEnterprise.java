/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Citizen.Citizen;
import Business.Citizen.CitizenDirectory;
import Business.Role.CitizenRole;
import Business.Role.PublicSectorAdmin;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class PublicSectorEnterprise extends Enterprise {

    private CitizenDirectory citizenDirectory;
    public PublicSectorEnterprise(String name){
        super(name, EnterpriseType.PublicSector);
        this.citizenDirectory=new CitizenDirectory();
    }
    public CitizenDirectory getCitizenDirectory() {
        return citizenDirectory;
    }

    public void setCitizenDirectory(CitizenDirectory citizenDirectory) {
        this.citizenDirectory = citizenDirectory;
    }
    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new CitizenRole());
        return roles;
        
    }
}
    

