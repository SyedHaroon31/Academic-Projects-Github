/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Order.Order;
import Business.Order.OrderItem;

/**
 *
 * @author haroonperveez
 */
public class LabRequestEquipment extends WorkRequest {
    private Order order;
    private String reply;
    public LabRequestEquipment(Order order)
    {
        this.order=order;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    } 

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
    public int getOrderPrice()
    {
        int total=0;
        for(OrderItem oi :order.getOrderItemList())
        {
            total+=(oi.getProduct().getProductPrice()*oi.getQuantity());
        }
        return total;
    }
    
    
        @Override
    public String toString(){
        return String.valueOf(this.order.getOrderNum());
    }
}
