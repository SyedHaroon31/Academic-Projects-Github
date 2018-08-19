/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;
import java.util.List;
import Business.Product.Product;

/**
 *
 * @author Ashish
 */
public class Order {
    private List<OrderItem> orderItemList;
    private int orderNum;
    private static int count =0;
    
    public Order() {  
        count++;
        this.orderNum = count;
        this.orderItemList = new ArrayList<>();  

     }

    public static int getCount() {
        return count;
    }

    
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    
    public OrderItem addOrderItem(Product p,int q){
        OrderItem o = new OrderItem(p);
        o.setQuantity(q);
        orderItemList.add(o);
        return o;
    }
    
    public void removeProduct(OrderItem o){
        orderItemList.remove(o);
    }

    
}
