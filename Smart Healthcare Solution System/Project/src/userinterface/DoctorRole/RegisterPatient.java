/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Citizen.CitizenDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PublicSectorEnterprise;
import Business.Organization.DoctorOrganization;
import static Business.Organization.Organization.Type.Citizen;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Business.Citizen.*;
import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Patient.Encounter;
import java.util.ArrayList;
import userinterface.SystemAdminWorkAreas.SystemAdminWorkAreaJPanel;

/**
 *
 * @author haroonperveez
 */
public class RegisterPatient extends javax.swing.JPanel {

    /**
     * Creates new form RegisterPatient
     */
    
    private JPanel userProcessContainer;
    private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private Patient patient;
    private EnterpriseDirectory ed;
    private CitizenDirectory citizenDirectory;
    public RegisterPatient(JPanel userProcessContainer, UserAccount account, Enterprise enterprise,EcoSystem business,DoctorOrganization organization,EnterpriseDirectory ed,Citizen curCitizen, Patient currPatient,int action) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        this.organization=organization;
        this.ed =ed;
        int t=0;
        if(patient!=null)
        {
            if(this.patient.isInfoComplete())
            {
                lblStatus.setText("Patient Profile Complete!");
                lblStatus1.setText("Patient Profile Complete!");
                lblStatus2.setText("Patient Profile Complete!");
                lblStatus3.setText("Patient Profile Complete!");
            }
            else
            {
                lblStatus.setText("Patient Profile Incomplete!");
                lblStatus1.setText("Patient Profile Incomplete!");
                lblStatus2.setText("Patient Profile Incomplete!");
                lblStatus3.setText("Patient Profile Incomplete!");
            }
        }
        else
        {
            lblStatus.setText("Patient Profile Incomplete!");
        }
        if(curCitizen==null && currPatient==null)
        {
            dateTxtField.setEnabled(true);
            nameTxTField.setEnabled(true);
            this.patient=((HospitalEnterprise) enterprise).getPatientDirectory().createPatinet();
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setEnabledAt(2, true);
            jTabbedPane1.setEnabledAt(3, true);
        }
        else if(curCitizen!=null)
        {
            dateTxtField.setEnabled(false);
            nameTxTField.setEnabled(false);
            this.patient=((HospitalEnterprise) enterprise).getPatientDirectory().createPatinet();
            this.patient.setCitizen(curCitizen);
            this.patient.setPersonalDetails(curCitizen);
            addBtn.setText("Update & Next");
            jTabbedPane1.setEnabledAt(1, false);
            jTabbedPane1.setEnabledAt(2, false);
            jTabbedPane1.setEnabledAt(3, false);
        }
        else if(currPatient!=null)
        {
            dateTxtField.setEnabled(false);
            nameTxTField.setEnabled(false);
            this.patient=currPatient;   
            t=1;
            addBtn.setText("Save Encounter");
            jTabbedPane1.setEnabledAt(2, false);
            jTabbedPane1.setEnabledAt(3, false);
            fillGeneralDetails(patient,null);
        }
        pidTxtField.setText(String.valueOf(patient.getPatientId()));     
        pidTxtField1.setText(String.valueOf(patient.getPatientId()));     
        pidTxtField2.setText(String.valueOf(patient.getPatientId()));     
        pidTxtField3.setText(String.valueOf(patient.getPatientId()));     
        jTabbedPane1.setSelectedIndex(0+t); 
    }
public void fillGeneralDetails(Patient p,Citizen c)
{
    SimpleDateFormat dtFormat =  new SimpleDateFormat ("MM/dd/yyyy");
    nameTxTField.setText(p.getFirstName());
    lastNameTxtField.setText(p.getLastName());
    dateTxtField.setText(dtFormat.format(p.getDateofBirth()));
    ssnTxtfield.setText(String.valueOf(p.getSsn()));
    emailIdTextField.setText(patient.getEmailAddress());
    phoneNumberTexTField.setText(String.valueOf(p.getContactNumber()));
    issuesArea.setText(p.getIssue());
    if(p.getGender().toLowerCase().equals("male"))
    {
        MaleBtn.setSelected(true);
        Female.setSelected(false);
    }
    else if(p.getGender().toLowerCase().equals("female"))
    {
        MaleBtn.setSelected(false);
        Female.setSelected(true);
    }
    
    if(p.getPrevVist().toLowerCase().equals("yes"))
    {
        yesBtn.setSelected(true);
        noBtn.setSelected(false);
    }
    else if(p.getGender().toLowerCase().equals("no"))
    {
        yesBtn.setSelected(false);
        noBtn.setSelected(true);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Gender = new javax.swing.ButtonGroup();
        PreviousVisit = new javax.swing.ButtonGroup();
        Relation = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        searchPIDtxtField = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dateTxtField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailIdTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        MaleBtn = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        phoneNumberTexTField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameTxTField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        issuesArea = new javax.swing.JTextArea();
        yesBtn = new javax.swing.JRadioButton();
        noBtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        ssnTxtfield = new javax.swing.JTextField();
        lastNameTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pidTxtField = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pidTxtField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tempTxTField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pulseTxtField3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        insulinTxtField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cholestrolLevel = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lowBP = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        HighBp = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        weightTxtField = new javax.swing.JTextField();
        heightTxtField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        BMITxtField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        lblStatus1 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        gluTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        pidTxtField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        insuranceCompanyTxtField = new javax.swing.JTextField();
        policyNumberTxtField = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        groupNumberTxtField = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        self = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        spouse = new javax.swing.JRadioButton();
        stateTxtField = new javax.swing.JTextField();
        other = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        child = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        deductablesTxtField = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        companyNumber = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        lblStatus2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pidTxtField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        q3b = new javax.swing.JRadioButton();
        q3c = new javax.swing.JRadioButton();
        q3d = new javax.swing.JRadioButton();
        q3e = new javax.swing.JRadioButton();
        q3a = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        q4b = new javax.swing.JRadioButton();
        q4a = new javax.swing.JRadioButton();
        jLabel39 = new javax.swing.JLabel();
        q5a = new javax.swing.JRadioButton();
        q5b = new javax.swing.JRadioButton();
        jLabel40 = new javax.swing.JLabel();
        q6b = new javax.swing.JRadioButton();
        q6a = new javax.swing.JRadioButton();
        jLabel41 = new javax.swing.JLabel();
        q7b = new javax.swing.JRadioButton();
        q7a = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        exerciseTxTfield = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        longTxtField = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        oftenTxtField = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        q1a = new javax.swing.JRadioButton();
        q1b = new javax.swing.JRadioButton();
        jLabel49 = new javax.swing.JLabel();
        q1c = new javax.swing.JRadioButton();
        q1d = new javax.swing.JRadioButton();
        q1e = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        q2e = new javax.swing.JRadioButton();
        q2d = new javax.swing.JRadioButton();
        q2c = new javax.swing.JRadioButton();
        q2b = new javax.swing.JRadioButton();
        q2a = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        lblStatus3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(44, 62, 80));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Patient Details");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        searchPIDtxtField.setBackground(new java.awt.Color(255, 255, 255));
        searchPIDtxtField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Date of Birth:");

        dateTxtField.setName("DOB"); // NOI18N
        dateTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxtFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Email id:");

        emailIdTextField.setName("Email"); // NOI18N

        jLabel8.setText("Gender:");

        Gender.add(MaleBtn);
        MaleBtn.setText("Male");

        Gender.add(Female);
        Female.setText("Female");

        jLabel9.setText("Phone Number:");

        phoneNumberTexTField.setName("Contact"); // NOI18N

        jLabel10.setText("Previously Visited to Same hospital ");

        addBtn.setText("Save & Next");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("First Name :");

        nameTxTField.setName("First Name"); // NOI18N

        jLabel2.setText("Issues :");

        issuesArea.setColumns(20);
        issuesArea.setRows(5);
        issuesArea.setName("Issue"); // NOI18N
        jScrollPane2.setViewportView(issuesArea);

        PreviousVisit.add(yesBtn);
        yesBtn.setText("Yes");

        PreviousVisit.add(noBtn);
        noBtn.setText("No");

        jLabel3.setText("SSN");

        ssnTxtfield.setName("SSn"); // NOI18N

        lastNameTxtField.setName("Last Name"); // NOI18N

        jLabel4.setText("Last Name:");

        jLabel11.setText("PID:");

        pidTxtField.setEnabled(false);

        lblStatus.setText("<<Status>>");

        javax.swing.GroupLayout searchPIDtxtFieldLayout = new javax.swing.GroupLayout(searchPIDtxtField);
        searchPIDtxtField.setLayout(searchPIDtxtFieldLayout);
        searchPIDtxtFieldLayout.setHorizontalGroup(
            searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pidTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                                .addGap(362, 362, 362)
                                .addComponent(jLabel64))
                            .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                                .addComponent(addBtn))))
                    .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameTxTField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                                        .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phoneNumberTexTField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(116, 116, 116)
                                        .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ssnTxtfield)
                                            .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                                                .addComponent(MaleBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Female))
                                            .addComponent(dateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(yesBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noBtn)))))
                .addContainerGap())
        );
        searchPIDtxtFieldLayout.setVerticalGroup(
            searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(pidTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus)
                            .addComponent(addBtn)))
                    .addGroup(searchPIDtxtFieldLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel64)))
                .addGap(45, 45, 45)
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTxTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lastNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(MaleBtn)
                    .addComponent(Female))
                .addGap(9, 9, 9)
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ssnTxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(phoneNumberTexTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(searchPIDtxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(yesBtn)
                    .addComponent(noBtn))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("General", searchPIDtxtField);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pidTxtField1.setEnabled(false);

        jLabel12.setText("PID:");

        jButton2.setText("Save & Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tempTxTField3.setName("Temperature"); // NOI18N

        jLabel16.setText("pounds");

        jLabel17.setText("Pulse:");

        jLabel18.setText("cms");

        pulseTxtField3.setName("Pulse"); // NOI18N

        jLabel19.setText("F");

        jLabel20.setText("Insulin Level:");

        jLabel21.setText("bpm");

        insulinTxtField.setName("Insulin"); // NOI18N

        jLabel22.setText("mg/DL");

        jLabel23.setText("Cholestrol:");

        cholestrolLevel.setName("Cholestrol"); // NOI18N

        jLabel24.setText("uIU/mL");

        jLabel25.setText("Blood Pressure");

        lowBP.setName("BP1"); // NOI18N

        jLabel26.setText("/");

        HighBp.setName("BP2"); // NOI18N

        jLabel27.setText("Weight:");

        jLabel28.setText("Height:");

        weightTxtField.setName("WT"); // NOI18N

        heightTxtField.setName("HT"); // NOI18N

        jLabel29.setText("BMI");

        BMITxtField.setName("BMI"); // NOI18N

        jLabel30.setText("Temperature:");

        lblStatus1.setText("<<Status>>");

        jLabel52.setText("Glucose:");

        gluTxt.setName("Glucose"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(32, 32, 32)
                        .addComponent(tempTxTField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(32, 32, 32)
                        .addComponent(pulseTxtField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(32, 32, 32)
                        .addComponent(insulinTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23)
                            .addComponent(jLabel29))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cholestrolLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lowBP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HighBp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BMITxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(32, 32, 32)
                        .addComponent(gluTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel19))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(weightTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(heightTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))))
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pidTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pidTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(lblStatus1)
                    .addComponent(jButton2))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(gluTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(tempTxTField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pulseTxtField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insulinTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cholestrolLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(lowBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(HighBp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(BMITxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(weightTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(heightTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vitals", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pidTxtField2.setEnabled(false);

        jLabel13.setText("PID:");

        jLabel31.setText("Insurance Company :");

        insuranceCompanyTxtField.setName("Company Name"); // NOI18N

        policyNumberTxtField.setName("Policy No"); // NOI18N

        jLabel32.setText("Policy Number:");

        groupNumberTxtField.setName("Group No"); // NOI18N

        jLabel33.setText("Group Number:");

        Relation.add(self);
        self.setText("Self");

        jLabel34.setText("State:");

        Relation.add(spouse);
        spouse.setText("Spouse");

        stateTxtField.setName("State"); // NOI18N

        Relation.add(other);
        other.setText("Other");

        jLabel35.setText("Relation To Patient:");

        Relation.add(child);
        child.setText("Child");

        jLabel36.setText("Deductables");

        deductablesTxtField.setName("Deduclables"); // NOI18N

        jLabel37.setText("Insurance Company Number :");

        companyNumber.setName("Company No"); // NOI18N

        jButton3.setText("Save & Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblStatus2.setText("<<Status>>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insuranceCompanyTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(groupNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(policyNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(companyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deductablesTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(self)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spouse)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(child)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(other)
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pidTxtField2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pidTxtField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(lblStatus2)
                    .addComponent(jButton3))
                .addGap(57, 57, 57)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(insuranceCompanyTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(policyNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(groupNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(stateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(self)
                    .addComponent(spouse)
                    .addComponent(other)
                    .addComponent(child))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(deductablesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(companyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Insurance", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pidTxtField3.setEnabled(false);

        jLabel14.setText("PID:");

        buttonGroup3.add(q3b);
        q3b.setText("Slightly");

        buttonGroup3.add(q3c);
        q3c.setText("Mild Pain");

        buttonGroup3.add(q3d);
        q3d.setText("Moderate Pain");

        buttonGroup3.add(q3e);
        q3e.setText("Sever Pain");

        buttonGroup3.add(q3a);
        q3a.setText("Not at all");

        jLabel38.setText("4)  Diabetes: Any problems with medications? ");

        buttonGroup4.add(q4b);
        q4b.setText("No");

        buttonGroup4.add(q4a);
        q4a.setText("Yes");

        jLabel39.setText("5)  High blood pressure: Any problems with meds?");

        buttonGroup5.add(q5a);
        q5a.setText("Yes");

        buttonGroup5.add(q5b);
        q5b.setText("No");

        jLabel40.setText("6)  High cholesterol: Any problems with meds?");

        buttonGroup6.add(q6b);
        q6b.setText("No");

        buttonGroup6.add(q6a);
        q6a.setText("Yes");

        jLabel41.setText("7)  Depression: Any problems with meds?");

        buttonGroup7.add(q7b);
        q7b.setText("No");

        buttonGroup7.add(q7a);
        q7a.setText("Yes");

        jLabel42.setText("8)  Exercise: What do you do?");

        exerciseTxTfield.setName("excersice name"); // NOI18N

        jLabel43.setText("How long? ");

        jLabel44.setText("how Often?");

        jLabel46.setText("minutes");

        jLabel47.setText("days");

        jLabel48.setText("1)  During the past four weeks, how much have you been bothered by emotional problems such as feeling anxious, depressed, irritable, sad");

        buttonGroup1.add(q1a);
        q1a.setText("Not at all");

        buttonGroup1.add(q1b);
        q1b.setText("Slightly");

        jLabel49.setText(" How much have you been bothered by emotional problems such as feeling anxious, depressed, irritable, sad, or downhearted and blue?");

        buttonGroup1.add(q1c);
        q1c.setText("Moderately");

        buttonGroup1.add(q1d);
        q1d.setText("Quite a bit");

        buttonGroup1.add(q1e);
        q1e.setText("Extremely");

        jLabel50.setText("2)  During the past four weeks, has your physical and emo- tional health limited your social activities with family friends, neighbors, or groups?");

        buttonGroup2.add(q2e);
        q2e.setText("Extremely");

        buttonGroup2.add(q2d);
        q2d.setText("Quite a bit");

        buttonGroup2.add(q2c);
        q2c.setText("Moderately");

        buttonGroup2.add(q2b);
        q2b.setText("Slightly");

        buttonGroup2.add(q2a);
        q2a.setText("Not at all");

        jLabel51.setText("3)  During the past four weeks, how much bodily pain have you generally had?:");

        lblStatus3.setText("<<Status>>");

        jButton4.setText("Finish");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel50)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(q7a)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(q7b))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(q6a)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(q6b))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(q5a)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(q5b))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(q4a)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(q4b))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(exerciseTxTfield, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(longTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oftenTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47))
                            .addComponent(jLabel51)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(q3a)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q3b)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q3c)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q3d)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q3e))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(q2a)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q2b)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q2c)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q2d)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q2e))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(q1a)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q1b)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q1c)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q1d)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q1e))
                            .addComponent(jLabel41)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel49)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pidTxtField3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pidTxtField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(lblStatus3)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q1a)
                    .addComponent(q1b)
                    .addComponent(q1c)
                    .addComponent(q1d)
                    .addComponent(q1e))
                .addGap(18, 18, 18)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q2a)
                    .addComponent(q2b)
                    .addComponent(q2c)
                    .addComponent(q2d)
                    .addComponent(q2e))
                .addGap(18, 18, 18)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q3a)
                    .addComponent(q3b)
                    .addComponent(q3c)
                    .addComponent(q3d)
                    .addComponent(q3e))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q4a)
                    .addComponent(q4b))
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q5a)
                    .addComponent(q5b))
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q6a)
                    .addComponent(q6b))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q7a)
                    .addComponent(q7b))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(exerciseTxTfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(longTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(oftenTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Questionnaire", jPanel5);

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel dwj = (DoctorWorkAreaJPanel) component;
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            if(patient != null){
            if(buttonGroup1.getSelection()==null
            || buttonGroup2.getSelection()==null || buttonGroup3.getSelection()==null|| buttonGroup4.getSelection()==null|| buttonGroup5.getSelection()==null
            || buttonGroup6.getSelection()==null|| buttonGroup7.getSelection()==null )
            {
                JOptionPane.showMessageDialog(null,"Please enter all fields Correctly");
                return;
            }

        if(q1a.isSelected())
        {
            patient.getQuestionnaire().setQ1("Not At All");
        }
        if(q1b.isSelected())
        {
            patient.getQuestionnaire().setQ1("Slightly");
        }
        if(q1c.isSelected())
        {
            patient.getQuestionnaire().setQ1("Moderate");
        }
        if(q1d.isSelected())
        {
            patient.getQuestionnaire().setQ1("Quite a bit");
        }
        if(q1e.isSelected())
        {
            patient.getQuestionnaire().setQ1("Extremely");
        }

        ////Q2.....
        if(q2a.isSelected())
        {
            patient.getQuestionnaire().setQ2("Not At All");
        }
        if(q2b.isSelected())
        {
            patient.getQuestionnaire().setQ2("Slightly");
        }
        if(q2c.isSelected())
        {
            patient.getQuestionnaire().setQ2("Moderate");
        }
        if(q2d.isSelected())
        {
            patient.getQuestionnaire().setQ2("Quite a bit");
        }
        if(q2e.isSelected())
        {
            patient.getQuestionnaire().setQ2("Extremely");
        }

        ////Q3

        if(q3a.isSelected())
        {
            patient.getQuestionnaire().setQ3("Not At All");
        }
        if(q3b.isSelected())
        {
            patient.getQuestionnaire().setQ3("Slightly");
        }
        if(q3c.isSelected())
        {
            patient.getQuestionnaire().setQ3("Moderate");
        }
        if(q3d.isSelected())
        {
            patient.getQuestionnaire().setQ3("Quite a bit");
        }
        if(q3e.isSelected())
        {
            patient.getQuestionnaire().setQ3("Extremely");
        }

        //////////Q4

        if(q4a.isSelected())
        {
            patient.getQuestionnaire().setQ4("Yes");
        }
        if(q4b.isSelected())
        {
            patient.getQuestionnaire().setQ4("No");
        }

        /////Q5

        if(q5a.isSelected())
        {
            patient.getQuestionnaire().setQ5("Yes");
        }
        if(q5b.isSelected())
        {
            patient.getQuestionnaire().setQ5("No");
        }

        ////Q6

        if(q6a.isSelected())
        {
            patient.getQuestionnaire().setQ6("Yes");
        }
        if(q6b.isSelected())
        {
            patient.getQuestionnaire().setQ6("No");
        }

        ///Q7

        if(q7a.isSelected())
        {
            patient.getQuestionnaire().setQ7("Yes");
        }
        if(q7b.isSelected())
        {
            patient.getQuestionnaire().setQ7("No");
        }

        ///Q8

        patient.getQuestionnaire().setExercise(exerciseTxTfield.getText());
        patient.getQuestionnaire().setOften(oftenTxtField.getText());
        patient.getQuestionnaire().setTime(Integer.parseInt(longTxtField.getText()));

        

        JOptionPane.showMessageDialog(null,"Details added successfully! Profile Complete");
        patient.setInfoComplete(true);//make function to check all details
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel dwj = (DoctorWorkAreaJPanel) component;
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        
    }
    else {
        JOptionPane.showMessageDialog(null,"Previous details not entered, please go back");
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        if(patient != null){
            if((insuranceCompanyTxtField.getText().isEmpty())||(groupNumberTxtField.getText().isEmpty())|| (policyNumberTxtField.getText().isEmpty())||
            (stateTxtField.getText().isEmpty()) || (deductablesTxtField.getText().isEmpty()) || (insuranceCompanyTxtField.getText().isEmpty()) || Gender.getSelection()==null
            || Relation.getSelection()==null)
            {
                JOptionPane.showMessageDialog(null,"Please enter all fields Correctly");
                return;
            }
            String check="";
            check = utility.Validator.ValidateTextFields(insuranceCompanyTxtField,true,0,0,25);
            if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
            check = utility.Validator.ValidateTextFields(policyNumberTxtField,true,3,0,5);
            if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
            check = utility.Validator.ValidateTextFields(groupNumberTxtField,true,3,0,5);
            if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
            check = utility.Validator.ValidateTextFields(stateTxtField,true,0,0,2);
            if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
            check = utility.Validator.ValidateTextFields(deductablesTxtField,true,3,0,3);
            if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
            check = utility.Validator.ValidateTextFields(companyNumber,true,3,10,10);
            if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
            
            patient.getInsurance().setInsuranceCompany(insuranceCompanyTxtField.getText());
            patient.getInsurance().setGroupno(Integer.parseInt(groupNumberTxtField.getText()));
            patient.getInsurance().setPolicyNo(Long.parseLong(policyNumberTxtField.getText()));
            patient.getInsurance().setState(stateTxtField.getText());
            patient.getInsurance().setDeductables(Double.parseDouble(deductablesTxtField.getText()));
            patient.getInsurance().setInsuranceCompNo(Long.parseLong(companyNumber.getText()));

            if(self.isSelected())
            {
                patient.getInsurance().setRelationToPatient("Self");
            }
            if(spouse.isSelected())
            {
                patient.getInsurance().setRelationToPatient("Spouse");
            }

            if(child.isSelected())
            {
                patient.getInsurance().setRelationToPatient("child");
            }
            if(other.isSelected())
            {
                patient.getInsurance().setRelationToPatient("other");
            }

            JOptionPane.showMessageDialog(null,"Insurance verified,please proceed next page");
            jTabbedPane1.setSelectedIndex(3);
        }
        else {
            JOptionPane.showMessageDialog(null,"Previous details not entered, please go back");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(patient !=null){
            try{
                if((HighBp.getText().isEmpty())||(lowBP.getText().isEmpty())|| (weightTxtField.getText().isEmpty())||
                (heightTxtField.getText().isEmpty()) || (tempTxTField3.getText().isEmpty()) || (pulseTxtField3.getText().isEmpty())||
                (cholestrolLevel.getText().isEmpty()) || (insulinTxtField.getText().isEmpty()) || ( BMITxtField.getText().isEmpty())|| ( gluTxt.getText().isEmpty()))
                {
                    JOptionPane.showMessageDialog(null,"Please enter all fields Correctly");
                    return;
                }
                String check="";
                check = utility.Validator.ValidateTextFields(gluTxt,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
                check = utility.Validator.ValidateTextFields(tempTxTField3,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
                check = utility.Validator.ValidateTextFields(insulinTxtField,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
                check = utility.Validator.ValidateTextFields(BMITxtField,true,1,0,5);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
                check = utility.Validator.ValidateTextFields(cholestrolLevel,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
                check = utility.Validator.ValidateTextFields(lowBP,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
                check = utility.Validator.ValidateTextFields(HighBp,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}                
                check = utility.Validator.ValidateTextFields(weightTxtField,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
                check = utility.Validator.ValidateTextFields(heightTxtField,true,3,0,3);
                if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}                
                if(patient.isInfoComplete())
                {
                    Encounter e=patient.getEncounterList().addEncounter();
                    e.getVitals().setBphigh(Integer.parseInt(HighBp.getText()));
                    e.getVitals().setBplow(Integer.parseInt(lowBP.getText()));
                    e.getVitals().setWeight(Integer.parseInt(weightTxtField.getText()));
                    e.getVitals().setHeight(Integer.parseInt(heightTxtField.getText()));
                    e.getVitals().setTemperature(Integer.parseInt(tempTxTField3.getText()));
                    e.getVitals().setPulse(Integer.parseInt(pulseTxtField3.getText()));
                    e.getVitals().setCholestrol(Integer.parseInt(cholestrolLevel.getText()));
                    e.getVitals().setInsulinLevel(Integer.parseInt(insulinTxtField.getText()));
                    e.getVitals().setBmi(Double.parseDouble(BMITxtField.getText()));
                    e.getVitals().setGlucose(Integer.parseInt(gluTxt.getText()));

                    JOptionPane.showMessageDialog(null,"Vitals Recorded Succesfully");
                    
                    userProcessContainer.remove(this);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.previous(userProcessContainer);                    
                }
                else
                {
                    patient.getVitals().setBphigh(Integer.parseInt(HighBp.getText()));
                    patient.getVitals().setBplow(Integer.parseInt(lowBP.getText()));
                    patient.getVitals().setWeight(Integer.parseInt(weightTxtField.getText()));
                    patient.getVitals().setHeight(Integer.parseInt(heightTxtField.getText()));
                    patient.getVitals().setTemperature(Integer.parseInt(tempTxTField3.getText()));
                    patient.getVitals().setPulse(Integer.parseInt(pulseTxtField3.getText()));
                    patient.getVitals().setCholestrol(Integer.parseInt(cholestrolLevel.getText()));
                    patient.getVitals().setInsulinLevel(Integer.parseInt(insulinTxtField.getText()));
                    patient.getVitals().setBmi(Double.parseDouble(BMITxtField.getText()));
                    patient.getVitals().setGlucose(Integer.parseInt(gluTxt.getText()));

                    Encounter e=patient.getEncounterList().addEncounter();
                    e.setVitals(patient.getVitals());
                    JOptionPane.showMessageDialog(null,"Vitals Added Succesfully, proceed to the next page");
                    jTabbedPane1.setSelectedIndex(2);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

        else {
            JOptionPane.showMessageDialog(null,"Previous enters not detailed, please go back");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dtFormat =  new SimpleDateFormat ("MM/dd/yyyy");

        if(nameTxTField.getText().isEmpty()|| lastNameTxtField.getText().isEmpty() || dateTxtField.getText().isEmpty()
            || ssnTxtfield.getText().isEmpty() || emailIdTextField.getText().isEmpty() || phoneNumberTexTField.getText().isEmpty()
            || Gender.getSelection()==null || PreviousVisit.getSelection()==null)
            {
                JOptionPane.showMessageDialog(null,"Enter all Details in right Format","Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

        else{
        String check = "";
        
        check = utility.Validator.ValidateTextFields(ssnTxtfield,true,3,9,9);
        if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
        check = utility.Validator.ValidateTextFields(nameTxTField,true,0,3,25);
        if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
        check = utility.Validator.ValidateTextFields(lastNameTxtField,true,0,2,25);
        if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
        check = utility.Validator.ValidateTextFields(phoneNumberTexTField,true,3,10,10);
        if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
        check = utility.Validator.ValidateTextFields(dateTxtField,true,2,5,25);
        if(!check.equals("")){JOptionPane.showMessageDialog(null,check,"Alert",JOptionPane.WARNING_MESSAGE);return;}
        
        
            try{
                patient.setFirstName(nameTxTField.getText());
                patient.setLastName(lastNameTxtField.getText());
                patient.setDateofBirth(dtFormat.parse(dateTxtField.getText()));
                patient.setSsn(Long.parseLong(ssnTxtfield.getText()));
                patient.setIssue(issuesArea.getText());
                patient.setEmailAddress(emailIdTextField.getText());
                patient.setContactNumber(Long.parseLong(phoneNumberTexTField.getText()));

                if(MaleBtn.isSelected())
                {
                    patient.setGender("Male");
                }
                if(Female.isSelected())
                {
                    patient.setGender("Female");
                }

                if(yesBtn.isSelected())
                {
                    patient.setPrevVist("Yes");
                }
                if(noBtn.isSelected())
                {
                    patient.setPrevVist("No");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error"+e);
                 return;
            }
            JOptionPane.showMessageDialog(null,"Details Saved, Please proceed next page");

        }
        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_addBtnActionPerformed

    private void dateTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTxtFieldActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BMITxtField;
    private javax.swing.JRadioButton Female;
    private javax.swing.ButtonGroup Gender;
    private javax.swing.JTextField HighBp;
    private javax.swing.JRadioButton MaleBtn;
    private javax.swing.ButtonGroup PreviousVisit;
    private javax.swing.ButtonGroup Relation;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JRadioButton child;
    private javax.swing.JTextField cholestrolLevel;
    private javax.swing.JTextField companyNumber;
    private javax.swing.JTextField dateTxtField;
    private javax.swing.JTextField deductablesTxtField;
    private javax.swing.JTextField emailIdTextField;
    private javax.swing.JTextField exerciseTxTfield;
    private javax.swing.JTextField gluTxt;
    private javax.swing.JTextField groupNumberTxtField;
    private javax.swing.JTextField heightTxtField;
    private javax.swing.JTextField insulinTxtField;
    private javax.swing.JTextField insuranceCompanyTxtField;
    private javax.swing.JTextArea issuesArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastNameTxtField;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblStatus2;
    private javax.swing.JLabel lblStatus3;
    private javax.swing.JTextField longTxtField;
    private javax.swing.JTextField lowBP;
    private javax.swing.JTextField nameTxTField;
    private javax.swing.JRadioButton noBtn;
    private javax.swing.JTextField oftenTxtField;
    private javax.swing.JRadioButton other;
    private javax.swing.JTextField phoneNumberTexTField;
    private javax.swing.JTextField pidTxtField;
    private javax.swing.JTextField pidTxtField1;
    private javax.swing.JTextField pidTxtField2;
    private javax.swing.JTextField pidTxtField3;
    private javax.swing.JTextField policyNumberTxtField;
    private javax.swing.JTextField pulseTxtField3;
    private javax.swing.JRadioButton q1a;
    private javax.swing.JRadioButton q1b;
    private javax.swing.JRadioButton q1c;
    private javax.swing.JRadioButton q1d;
    private javax.swing.JRadioButton q1e;
    private javax.swing.JRadioButton q2a;
    private javax.swing.JRadioButton q2b;
    private javax.swing.JRadioButton q2c;
    private javax.swing.JRadioButton q2d;
    private javax.swing.JRadioButton q2e;
    private javax.swing.JRadioButton q3a;
    private javax.swing.JRadioButton q3b;
    private javax.swing.JRadioButton q3c;
    private javax.swing.JRadioButton q3d;
    private javax.swing.JRadioButton q3e;
    private javax.swing.JRadioButton q4a;
    private javax.swing.JRadioButton q4b;
    private javax.swing.JRadioButton q5a;
    private javax.swing.JRadioButton q5b;
    private javax.swing.JRadioButton q6a;
    private javax.swing.JRadioButton q6b;
    private javax.swing.JRadioButton q7a;
    private javax.swing.JRadioButton q7b;
    private javax.swing.JPanel searchPIDtxtField;
    private javax.swing.JRadioButton self;
    private javax.swing.JRadioButton spouse;
    private javax.swing.JTextField ssnTxtfield;
    private javax.swing.JTextField stateTxtField;
    private javax.swing.JTextField tempTxTField3;
    private javax.swing.JTextField weightTxtField;
    private javax.swing.JRadioButton yesBtn;
    // End of variables declaration//GEN-END:variables
}
