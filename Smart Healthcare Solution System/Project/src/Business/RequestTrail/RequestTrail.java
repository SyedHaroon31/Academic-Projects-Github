/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RequestTrail;

import Business.UserAccount.UserAccount;
import java.util.Date;
import utility.Constants;

/**
 *
 * @author Ashish
 */
public class RequestTrail {
    private int trailId;
    private UserAccount sender;
    private UserAccount reciever;
    private Date requestDate;
    private Date lastActionDate;
    private Constants.Status status;  
    private Constants.TrailLevel trailLevel;  

    public Constants.TrailLevel getTrailLevel() {
        return trailLevel;
    }

    public void setTrailLevel(Constants.TrailLevel trailLevel) {
        this.trailLevel = trailLevel;
    }
    
    
    public int getTrailId() {        
        return trailId;
    }

    public void setTrailId(int trailId) {//public only cz static problem
        this.trailId = trailId;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReciever() {
        return reciever;
    }

    public void setReciever(UserAccount reciever) {
        this.reciever = reciever;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getLastActionDate() {
        return lastActionDate;
    }

    public void setLastActionDate(Date lastActionDate) {
        this.lastActionDate = lastActionDate;
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) {
        this.status = status;
    }
    
    
}
