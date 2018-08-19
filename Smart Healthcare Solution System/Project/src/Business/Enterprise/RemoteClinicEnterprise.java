/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Role.remoteClinicAccountManager;
import Business.Role.remoteClinicManagerRole;
import Business.Travel.TravelScheduleDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.HashSet;

/**
 *
 * @author haroonperveez
 */
public class RemoteClinicEnterprise extends Enterprise {

    
     TravelScheduleDirectory travelScheduleDirectory;
     private WorkQueue fundReqQueue;
             
      public RemoteClinicEnterprise(String name) {
        super(name, EnterpriseType.RemoteClinic);
        travelScheduleDirectory = new TravelScheduleDirectory();
         fundReqQueue=new WorkQueue();
      }

    public TravelScheduleDirectory getTravelScheduleDirectory() {
        return travelScheduleDirectory;
    }

    public void setTravelScheduleDirectory(TravelScheduleDirectory travelScheduleDirectory) {
        this.travelScheduleDirectory = travelScheduleDirectory;
    }

   

    public WorkQueue getFundReqQueue() {
        return fundReqQueue;
    }

    public void setFundReqQueue(WorkQueue fundReqQueue) {
        this.fundReqQueue = fundReqQueue;
    }
      
      
      
    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new remoteClinicAccountManager());
        roles.add(new remoteClinicManagerRole());
        
        
        return roles;
    }
    
}
