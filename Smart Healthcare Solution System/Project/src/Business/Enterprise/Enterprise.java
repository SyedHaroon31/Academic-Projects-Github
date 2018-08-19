/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Patient.PatientDirectory;
import java.util.Date;


/**
 *
 * @author raunak
 */
public abstract class Enterprise extends Organization{

    private EnterpriseType enterpriseType;
    private Date lastAllocation;
    private OrganizationDirectory organizationDirectory;
    private long totalFunds;
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory(); 
        this.totalFunds=0;
    }
    
    public enum EnterpriseType{
        Hospital("Hospital"),Government("Government"),RemoteClinic("RemoteClinic"),PublicSector("PublicSector");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public long getTotalFunds() {
        return totalFunds;
    }
    public void updateTotalFunds(long requestPrice,int action) {
        if(action==1)
        {
            this.totalFunds=this.totalFunds+requestPrice;
        }
        else if(action==0)
        {
            this.totalFunds=this.totalFunds-requestPrice;
        }
    }
    

    public Date getLastAllocation() {
        return lastAllocation;
    }

    public void setLastAllocation(Date lastAllocation) {
        this.lastAllocation = lastAllocation;
    }



    
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
