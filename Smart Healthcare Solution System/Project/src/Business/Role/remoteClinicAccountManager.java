/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.remoteClinicFundOrganization;
import Business.Organization.remoteClinicManagerOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.TravelAccountManager.TravelAccountManagerWorkArea;

/**
 *
 * @author haroonperveez
 */
public class remoteClinicAccountManager extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new TravelAccountManagerWorkArea(userProcessContainer,  account, (remoteClinicFundOrganization) organization,  enterprise);
    }
    
}
