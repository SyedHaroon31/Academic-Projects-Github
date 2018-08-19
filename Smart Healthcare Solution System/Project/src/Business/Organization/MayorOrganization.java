/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MayorRole;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class MayorOrganization extends Organization {
    
    private  long totalFunds;
    private WorkQueue fundReqQueue;
    public MayorOrganization(){
        super(Organization.Type.Mayor.getValue());
        this.totalFunds=Long.parseLong(String.valueOf(utility.Constants.InitialFund.Mayor));
        fundReqQueue=new WorkQueue();
    }
    @Override
    public HashSet<Role> getSupportedRole() {
         roles = new HashSet<>();
         roles.add(new MayorRole() );
         return roles;
    }
    public long getTotalFunds() {
        return totalFunds;
    }

    public WorkQueue getFundReqQueue() {
        return fundReqQueue;
    }

    public void setFundReqQueue(WorkQueue fundReqQueue) {
        this.fundReqQueue = fundReqQueue;
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
    
}
