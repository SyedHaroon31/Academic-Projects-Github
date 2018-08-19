/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ashish
 */
public class EncounterDirectory {
    private ArrayList<Encounter> encounterList;
 
    
    public EncounterDirectory(){
        encounterList = new ArrayList<>();
    }

    public ArrayList<Encounter> getEncounterList() {
        return encounterList;
    }

    public void setEncounterList(ArrayList<Encounter> encounterList) {
        this.encounterList = encounterList;
    }
    public Encounter addEncounter(){
        Encounter e = new Encounter();
        e.setRecordDate(new Date());
        encounterList.add(e);
        return e;
    }
    public Encounter getFirstEncounter(){
        return encounterList.get(0);
    }
    public Encounter getLastEncounter(){
        return encounterList.get(encounterList.size()-1);
    }
}
