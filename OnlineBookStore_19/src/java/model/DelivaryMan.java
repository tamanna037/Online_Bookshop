/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class DelivaryMan {
    String dmId;
    String name;
    String contactno;
    String workingThana;
    String workingArea;
    String workingDistrict;
    int workingOn;
    int completed;

    public DelivaryMan(String dmId, String name, String contactno, int workingOn, int completed) {
        this.dmId = dmId;
        this.name = name;
        this.contactno = contactno;
        this.workingOn = workingOn;
        this.completed = completed;
    }

    public DelivaryMan(String dmId, String name, String contactno, String workingThana, String workingDistrict, int workingOn, int completed) {
        this.dmId = dmId;
        this.name = name;
        this.contactno = contactno;
        this.workingThana = workingThana;
        this.workingDistrict = workingDistrict;
        this.workingOn = workingOn;
        this.completed = completed;
    }

    public DelivaryMan(String dmId, String name, String contactno, String workingArea, int workingOn, int completed) {
        this.dmId = dmId;
        this.name = name;
        this.contactno = contactno;
        this.workingArea = workingArea;
        this.workingOn = workingOn;
        this.completed = completed;
    }
    

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public int getWorkingOn() {
        return workingOn;
    }

    public void setWorkingOn(int workingOn) {
        this.workingOn = workingOn;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
    
    
    public String getDmId() {
        return dmId;
    }

    public void setDmId(String dmId) {
        this.dmId = dmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getWorkingThana() {
        return workingThana;
    }

    public void setWorkingThana(String workingThana) {
        this.workingThana = workingThana;
    }

    public String getWorkingDistrict() {
        return workingDistrict;
    }

    public void setWorkingDistrict(String workingDistrict) {
        this.workingDistrict = workingDistrict;
    }

    @Override
    public String toString() {
        return "DelivaryMan{" + "dmId=" + dmId + ", name=" + name + ", contactno=" + contactno + ", workingThana=" + workingThana + ", workingArea=" + workingArea + ", workingDistrict=" + workingDistrict + ", workingOn=" + workingOn + ", completed=" + completed + '}';
    }
    
    
}
