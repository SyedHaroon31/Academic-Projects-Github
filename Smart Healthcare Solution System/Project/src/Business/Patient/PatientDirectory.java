/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Employee.*;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PatientDirectory {
    
    private ArrayList<Patient> patientList;

    public PatientDirectory() {
        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }
    
    
    public Patient createPatinet(){
        Patient patient=new Patient();
        patient.setPatientId(patientList.size()+1);
        patientList.add(patient);
        return patient;
    }
    
    public Patient searchPatient(int id){
        for(Patient patient : patientList){
        if(patient.getPatientId()==id){
            return patient;
        }
        
        }
        return null;
    }
}