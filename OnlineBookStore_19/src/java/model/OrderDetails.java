/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class OrderDetails {
    ArrayList<CartItem> itemList;
    String orderId;
    Date orderDate;
    int totalPrice;
    String address;
    String thana;
    String district;
    String delivaryStatus;
    String paymentStatus;

    public OrderDetails(ArrayList<CartItem> itemList, String orderId, 
            Date orderDate, int totalPrice, String address, String thana, 
            String district, String delivaryStatus, String paymentStatus) {
        this.itemList = itemList;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.address = address;
        this.thana = thana;
        this.district = district;
        this.delivaryStatus = delivaryStatus;
        this.paymentStatus = paymentStatus;
    }
    
    

    public ArrayList<CartItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<CartItem> itemList) {
        this.itemList = itemList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDelivaryStatus() {
        return delivaryStatus;
    }

    public void setDelivaryStatus(String delivaryStatus) {
        this.delivaryStatus = delivaryStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    
    
    
    
}
