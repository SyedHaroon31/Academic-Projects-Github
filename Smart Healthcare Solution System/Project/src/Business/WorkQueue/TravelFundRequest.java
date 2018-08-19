/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author haroonperveez
 */
public class TravelFundRequest extends WorkRequest{
    
    private long total;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

   


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

   
    @Override
    public String toString(){
        return this.getMessage();
    }
    
}
