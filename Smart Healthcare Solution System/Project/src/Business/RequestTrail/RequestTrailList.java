/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RequestTrail;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;
import utility.Constants;
import utility.Constants.Status;

/**
 *
 * @author Ashish
 */
public class RequestTrailList {
        private ArrayList<RequestTrail> requestTrailList;

    public RequestTrailList() {
        requestTrailList = new ArrayList<>();
    }
    public ArrayList<RequestTrail> getRequestTrailList() {
        return requestTrailList;
    }
    
    public RequestTrail addTrail(Status status,UserAccount sender,Constants.TrailLevel trailLevel){        
        RequestTrail p = new RequestTrail();
        p.setTrailId(this.requestTrailList.size()+1);
        p.setSender(sender);
        p.setRequestDate(new Date());
        p.setStatus(status);
        p.setTrailLevel(trailLevel);
        requestTrailList.add(p);
        return p;
    }
    public boolean updateTrail(Status status,UserAccount reciever,Constants.TrailLevel trailLevel){
        if(requestTrailList.isEmpty())
        {
            return false;
        }
        
        RequestTrail trail=requestTrailList.get(requestTrailList.size()-1);
        if(reciever!=null)
        {
            trail.setReciever(reciever);
        }
        if(status!=null)
        {
            trail.setStatus(status);
        }
        if(trailLevel!=null)
        {
            trail.setTrailLevel(trailLevel);
        }
        trail.setLastActionDate(new Date());
        return true;
    }
    public UserAccount getSender(Constants.TrailLevel trailLevel)
    {
        for(RequestTrail t:requestTrailList)
        {
            if(t.getTrailLevel().equals(trailLevel))
            {
                return t.getSender();
            }
        }
        return null;
    }
    public UserAccount getReciever(Constants.TrailLevel trailLevel)
    {
        for(RequestTrail t:requestTrailList)
        {
            if(t.getTrailLevel().equals(trailLevel))
            {
                return t.getReciever();
            }
        }
        return null;
    }       
    public Date getRequestDate(Constants.TrailLevel trailLevel)
    {
        for(RequestTrail t:requestTrailList)
        {
            if(t.getTrailLevel().equals(trailLevel))
            {
                return t.getRequestDate();
            }
        }
        return null;
    }       

}
