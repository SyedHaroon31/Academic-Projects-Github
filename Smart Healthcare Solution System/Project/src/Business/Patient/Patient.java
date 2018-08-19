/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Citizen.Citizen;
import java.util.Date;

/**
 *
 * @author haroonperveez
 */
public class Patient {
    
    private String firstName;
    private String lastName;
    private Date dateofBirth;
    private String address;
    private String Gender;
    private long contactNumber;
    private String EmailAddress;
    private String issue;
    private String history;
    private Long ssn;
    private int patientId;
    private String prevVist;
    private Citizen citizen;
    private boolean infoComplete;
    private EncounterDirectory encounterList;
    
    private Vitals vitals;
    private Insurance insurance;
    private Questionnaire questionnaire;
    
    
    public Patient() {      
        this.vitals= new Vitals();
        this.insurance = new Insurance();
        this.questionnaire=new Questionnaire();
        this.infoComplete=false;
        this.encounterList=new EncounterDirectory();
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
    public void setPersonalDetails(Citizen c) {
        this.firstName=c.getFirstName();
        this.lastName=c.getLastName();
        this.dateofBirth=c.getDateofBirth();
        this.Gender=c.getFirstName();
        this.contactNumber=c.getContactNumber();
        this.EmailAddress=c.getEmailAddress();
        this.ssn=c.getSsn();
        this.address=c.getAddress();
        
    }
    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    
    
    
    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public String getPrevVist() {
        return prevVist;
    }

    public void setPrevVist(String prevVist) {
        this.prevVist = prevVist;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }

    
    

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

   
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    
    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    
    
    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    

   
    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
    
     @Override
    public String toString() {
        return lastName;
    }

    public boolean isInfoComplete() {
        return infoComplete;
    }

    public void setInfoComplete(boolean infoComplete) {
        this.infoComplete = infoComplete;
    }

    public EncounterDirectory getEncounterList() {
        return encounterList;
    }

    public void setEncounterList(EncounterDirectory encounterList) {
        this.encounterList = encounterList;
    }
    

    
}
