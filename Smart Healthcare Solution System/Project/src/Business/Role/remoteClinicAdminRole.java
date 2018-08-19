/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Hospital.HospitalAdminWorkAreaJPanel;
import userinterface.RemoteClinic.Admin.RemoteClinicAdminWorkAreaJPanel;

/**
 *
 * @author haroonperveez
 */
public class remoteClinicAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new RemoteClinicAdminWorkAreaJPanel(userProcessContainer, enterprise);
    }
    
}
