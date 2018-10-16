/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ShownBookData implements Serializable{
    String id;
    String title;
    String author;
    String publication;
    String category;
    String subCategory;
    int price;
    String isbn;
    int pubYear;
    String edition;
    String language;
    int pageNo;
    String  description;
    String availability;
    int discount;
    int quantity;
    private ArrayList<String> authorList;
     private ArrayList<String> catList;
    
    
    public ShownBookData(){}
    public ShownBookData(String title, int price, String isbn, int pubYear, String edition, String language, int pageNo, String description, int discount) {
        this.title = title;
        this.price = price;
        this.isbn = isbn;
        this.pubYear = pubYear;
        this.edition = edition;
        this.language = language;
        this.pageNo = pageNo;
        this.description = description;
        this.discount = discount;
    }
    

    public ShownBookData(String id, String title, String author, String publication, String category,
            String subCategory, int price, String isbn, int pubYear, String edition, String language,
            int pageNo, String description, int discount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.category = category;
        this.subCategory = subCategory;
        this.price = price;
        this.isbn = isbn;
        this.pubYear = pubYear;
        this.edition = edition;
        this.language = language;
        this.pageNo = pageNo;
        this.description = description;
        //this.availability = availability;
        this.discount = discount;
    }
    
    

    public ShownBookData(String id, String title, int price, String isbn, int pubYear, String edition, String language, int pageNo, String description, int discount) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
        this.pubYear = pubYear;
        this.edition = edition;
        this.language = language;
        this.pageNo = pageNo;
        this.description = description;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
       
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
    
    
    public String getPublisher() {
        return publication;
    }
    
    public void setPublisher(String publication) {
        this.publication = publication;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    

   @Override
    public String toString() {
        return "ShownBookData{" + "title=" + title + ", author=" + author + ", publisher=" + publication + ", category=" + category + ", price=" + price + ", isbn=" + isbn + ", pubYear=" + pubYear + ", edition=" + edition + ", language=" + language + ", pageNo=" + pageNo + ", description=" + description + ", availability=" + availability + ", discount=" + discount + '}';
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the authorList
     */
    public ArrayList<String> getAuthorList() {
        return authorList;
    }

    /**
     * @param authorList the authorList to set
     */
    public void setAuthorList(ArrayList<String> authorList) {
        this.authorList = authorList;
    }

    /**
     * @return the catList
     */
    public ArrayList<String> getCatList() {
        return catList;
    }

    /**
     * @param catList the catList to set
     */
    public void setCatList(ArrayList<String> catList) {
        this.catList = catList;
    }

    

    
    
}
