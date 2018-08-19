/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Travel;

import java.util.ArrayList;

/**
 *
 * @author haroonperveez
 */
public class TravelScheduleDirectory {
    
    private ArrayList<TravelSchedule> travelScheduleList;
 
    
    public TravelScheduleDirectory(){
    
        travelScheduleList= new  ArrayList<>();
    }

    public ArrayList<TravelSchedule> getTravelScheduleList() {
        return travelScheduleList;
    }

    public void setTravelScheduleList(ArrayList<TravelSchedule> travelScheduleList) {
        this.travelScheduleList = travelScheduleList;
    }
    
     public TravelSchedule createRoute(){
        TravelSchedule ts = new TravelSchedule();
        travelScheduleList.add(ts);
        return ts;
    }
    
    public TravelSchedule searchTrvel(String source){
        for(TravelSchedule ts : travelScheduleList)
        {
        
           
                
                if(ts.getStop1().equalsIgnoreCase(source) || ts.getStop2().equalsIgnoreCase(source)|| ts.getStop3().equalsIgnoreCase(source) || ts.getStop4().equalsIgnoreCase(source))
                    { 
            return ts;
        
            }
           
            }
        return null;
        }
        
    

        
    public void deleteRoute(TravelSchedule ts)
    {
        travelScheduleList.remove(ts);
    }
    
    
}
