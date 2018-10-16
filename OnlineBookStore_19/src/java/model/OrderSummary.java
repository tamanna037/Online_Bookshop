/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class OrderSummary {
    String orderId;
    String customerId;
    int totalPrice;
    String Address;
    String thanaId;
    String thana;
    String district;
    Date date;
    String paymentStatus;
    String delivaryStatus;
    String delivaryMan;
    String delivaryManId;
    String assignedAdmin;

    public OrderSummary(String orderId, String customerId, int totalPrice, String Address, String thanaId, String thana, String district, Date date, String paymentStatus, String delivaryStatus, String delivaryMan, String delivaryManId, String assignedAdmin) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.Address = Address;
        this.thanaId = thanaId;
        this.thana = thana;
        this.district = district;
        this.date = date;
        this.paymentStatus = paymentStatus;
        this.delivaryStatus = delivaryStatus;
        this.delivaryMan = delivaryMan;
        this.delivaryManId = delivaryManId;
        this.assignedAdmin = assignedAdmin;
    }
    
    

    public String getDelivaryManId() {
        return delivaryManId;
    }

    public void setDelivaryManId(String delivaryManId) {
        this.delivaryManId = delivaryManId;
    }

    public String getThanaId() {
        return thanaId;
    }

    public void setThanaId(String thanaId) {
        this.thanaId = thanaId;
    }

    
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDelivaryStatus() {
        return delivaryStatus;
    }

    public void setDelivaryStatus(String delivaryStatus) {
        this.delivaryStatus = delivaryStatus;
    }

    public String getDelivaryMan() {
        return delivaryMan;
    }

    public void setDelivaryMan(String delivaryMan) {
        this.delivaryMan = delivaryMan;
    }

    public String getAssignedAdmin() {
        return assignedAdmin;
    }

    public void setAssignedAdmin(String assignedAdmin) {
        this.assignedAdmin = assignedAdmin;
    }

    @Override
    public String toString() {
        return "OrderSummary{" + "orderId=" + orderId + ", customerId=" + customerId + ", totalPrice=" + totalPrice + ", Address=" + Address + ", thanaId=" + thanaId + ", thana=" + thana + ", district=" + district + ", date=" + date + ", paymentStatus=" + paymentStatus + ", delivaryStatus=" + delivaryStatus + ", delivaryMan=" + delivaryMan + ", delivaryManId=" + delivaryManId + ", assignedAdmin=" + assignedAdmin + '}';
    }

    
    
    
}
