/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Ashish
 */
public class InitiateFundRequest extends WorkRequest{
    private long requestedFunds;
    private String remarks;


    public long getRequestedFunds() {
        return requestedFunds;
    }

    public void setRequestedFunds(long requestedFunds) {
        this.requestedFunds = requestedFunds;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
    
     @Override
    public String toString(){
        return String.valueOf(this.getRequestedFor());
    }
}
