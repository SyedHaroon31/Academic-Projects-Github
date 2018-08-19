/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ashish
 */
public class Encounter {
    private Date recordDate;
    private Vitals vitals;
    
    public Encounter()
    {
        this.vitals=new Vitals();
    }
    
    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }


    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }
    @Override
    public String toString() {
        SimpleDateFormat dtFormat =  new SimpleDateFormat ("MM/dd/yyyy HH:mm");
        return dtFormat.format(recordDate);
    }
}
