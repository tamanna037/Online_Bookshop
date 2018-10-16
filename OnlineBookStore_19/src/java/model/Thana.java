/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author DELL
 */
public class Thana {
    String thanaId;
    String thana;
    String zilla;

    public Thana() {
    }
    
    

    public Thana(String thanaId, String thana, String zilla) {
        this.thanaId = thanaId;
        this.thana = thana;
        this.zilla = zilla;
    }

    public Thana(String thana, String zilla) {
        this.thana = thana;
        this.zilla = zilla;
    }
    
    

    public String getThanaId() {
        return thanaId;
    }

    public void setThanaId(String thanaId) {
        this.thanaId = thanaId;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getZilla() {
        return zilla;
    }

    public void setZilla(String zilla) {
        this.zilla = zilla;
    }

    @Override
    public String toString() {
        return "Thana{" + "thanaId=" + thanaId + ", thana=" + thana + ", zilla=" + zilla + '}';
    }
    
    
    
    public ArrayList<Thana> parseThanaData(String s){
        ArrayList<Thana> arr = new ArrayList<Thana>();
         StringTokenizer st = new StringTokenizer(s," ,-");  
     while (st.hasMoreTokens()) {  
         Thana t = new Thana(st.nextToken(),st.nextToken());
         System.out.println(t);  
         arr.add(t);
     }  
        return arr;
    }
}
