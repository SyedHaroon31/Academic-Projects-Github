/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Order.MasterOrderCatalog;
import Business.Patient.PatientDirectory;
import Business.Role.DoctorRole;
import Business.Role.InventoryManager;
import Business.Role.LabRole;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.HashSet;

/**
 *
 * @author raunak
 */
public class HospitalEnterprise extends Enterprise{
    
    private WorkQueue fundReqQueue;
    private PatientDirectory patientDirectory;
    private MasterOrderCatalog moc;
    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
        patientDirectory= new PatientDirectory();
        fundReqQueue=new WorkQueue();
        moc=new MasterOrderCatalog();
    }

    public WorkQueue getFundReqQueue() {
        return fundReqQueue;
    }

    public MasterOrderCatalog getMoc() {
        return moc;
    }

   
    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new DoctorRole());
        roles.add(new LabRole());
        roles.add(new InventoryManager());
        
        return roles;
    }
    
    
    
}
