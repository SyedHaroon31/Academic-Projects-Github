/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.RequestTrail.RequestTrailList;
import Business.UserAccount.UserAccount;
import java.util.Date;
import utility.Constants.Status;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private int requestId;
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private Status status;
    private Date requestDate;
    private Date resolveDate;
    private String ReqType;
    private RequestTrailList trail;
    private Enterprise requestedFor;
    private static int count=0;
    
    public WorkRequest(){
        ++count;
        this.requestId=count;
        requestDate = new Date();
        ReqType=utility.Constants.ReqType.Other.toString();
        trail=new RequestTrailList();
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getReqType() {
        return ReqType;
    }

    public void setReqType(String ReqType) {
        this.ReqType = ReqType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }


    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public RequestTrailList getTrail() {
        return trail;
    }

    public void setTrail(RequestTrailList trail) {
        this.trail = trail;
    }


    public Enterprise getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(Enterprise requestedFor) {
        this.requestedFor = requestedFor;
    }


    
    @Override
    public String toString(){
        return String.valueOf(this.requestId);
    }
}
