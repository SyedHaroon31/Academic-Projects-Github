/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author haroonperveez
 */
public class Insurance {
    
    private String insuranceCompany;
    private long policyNo;
    private int groupno;
    private String relationToPatient;
    private String state;
    private double deductables;
    private long insuranceCompNo;

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public long getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(long policyNo) {
        this.policyNo = policyNo;
    }

    public int getGroupno() {
        return groupno;
    }

    public void setGroupno(int groupno) {
        this.groupno = groupno;
    }

    public String getRelationToPatient() {
        return relationToPatient;
    }

    public void setRelationToPatient(String relationToPatient) {
        this.relationToPatient = relationToPatient;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getDeductables() {
        return deductables;
    }

    public void setDeductables(double deductables) {
        this.deductables = deductables;
    }

    public long getInsuranceCompNo() {
        return insuranceCompNo;
    }

    public void setInsuranceCompNo(long insuranceCompNo) {
        this.insuranceCompNo = insuranceCompNo;
    }

   
    
    
}
