/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Travel;

/**
 *
 * @author haroonperveez
 */
public class TravelSchedule {
    
       private String Tno;
       private String stop1;
       private String stop2;
       private String stop3;
       private String stop4;
       private String stop1Time;
       private String stop2Time;
       private String stop3Time;
       private String stop4Time;

    public String getStop1Time() {
        return stop1Time;
    }

    public void setStop1Time(String stop1Time) {
        this.stop1Time = stop1Time;
    }

    public String getStop2Time() {
        return stop2Time;
    }

    public void setStop2Time(String stop2Time) {
        this.stop2Time = stop2Time;
    }

    public String getStop3Time() {
        return stop3Time;
    }

    public void setStop3Time(String stop3Time) {
        this.stop3Time = stop3Time;
    }

    public String getStop4Time() {
        return stop4Time;
    }

    public void setStop4Time(String stop4Time) {
        this.stop4Time = stop4Time;
    }

    public String getTno() {
        return Tno;
    }

    public void setTno(String Tno) {
        this.Tno = Tno;
    }
       

    
       
   

    public String getStop1() {
        return stop1;
    }

    public void setStop1(String stop1) {
        this.stop1 = stop1;
    }

    public String getStop2() {
        return stop2;
    }

    public void setStop2(String stop2) {
        this.stop2 = stop2;
    }

    public String getStop3() {
        return stop3;
    }

    public void setStop3(String stop3) {
        this.stop3 = stop3;
    }

    public String getStop4() {
        return stop4;
    }

    public void setStop4(String stop4) {
        this.stop4 = stop4;
    }
    
    
    
         @Override
    public String toString() {
        return Tno;
    }

   
    
       
    
}
