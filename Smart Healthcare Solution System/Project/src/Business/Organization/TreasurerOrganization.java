/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TreasurerRole;
import Business.WorkQueue.WorkQueue;
import java.util.HashSet;

/**
 *
 * @author ashish
 */
public class TreasurerOrganization extends Organization {
    private WorkQueue fundReqIniQueue;
      public TreasurerOrganization() {
        super(Organization.Type.Treasurer.getValue());
        fundReqIniQueue=new WorkQueue();
    }

    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new TreasurerRole() );
         return roles;
    }

    public WorkQueue getFundReqIniQueue() {
        return fundReqIniQueue;
    }

    public void setFundReqIniQueue(WorkQueue fundReqIniQueue) {
        this.fundReqIniQueue = fundReqIniQueue;
    }
    
}
