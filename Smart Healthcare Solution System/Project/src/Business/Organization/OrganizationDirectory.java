/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Accounts.getValue())){
            organization = new AccountsOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Mayor.getValue())){
            organization = new MayorOrganization();
            organizationList.add(organization);
        }
        
         else if (type.getValue().equals(Type.Treasurer.getValue())){
            organization = new TreasurerOrganization();
            organizationList.add(organization);
        }        
        
        else if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        
         else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        
         else if (type.getValue().equals(Type.InventoryManager.getValue())){
            organization = new InventoryManagerOrganization();
            organizationList.add(organization);
        }
        
         else if (type.getValue().equals(Type.remoteClinicTravelManager.getValue())){
            organization = new remoteClinicManagerOrganization();
            organizationList.add(organization);
        }
           else if (type.getValue().equals(Type.remoteClinicAccountManager.getValue())){
            organization = new remoteClinicFundOrganization();
            organizationList.add(organization);
        }
            else if (type.getValue().equals(Type.Citizen.getValue())){
            organization = new CitizenOrganization();
            organizationList.add(organization);
        }
        
           
        
        
        
        return organization;
    }
}