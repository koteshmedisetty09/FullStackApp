

/*
package com.grokonez.spring.restapi.mysql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="items")
public class items {






	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String name;
    private int quantity;
    @JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Cid", insertable = true, updatable = true)
    private Customer customer;
    
    public items(){
    }
    
    public items(String name,int quantity, Customer customer){
    	this.name = name;
    	this.quantity = quantity;
    	this.customer = customer;
    	
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // products
    public void setCompany(Customer customer){
    	this.customer = customer;
    }
    
    public Customer getCustomer(){
    	return this.customer;
    }
    
    
    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject customerObj = new JSONObject();
        customerObj.put("name", this.customer.getName());
        jsonInfo.put("company", customerObj);
        
        info = jsonInfo.toString();
        return info;
    }
}


*/







package com.grokonez.spring.restapi.mysql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="items")
public class items {






	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String name;
    private int price;
    
    private String photopath;

    
    @JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Cid", insertable = true, updatable = true)
    private Customer customer;
    
    public items(){
    }
    
    public items(String name,int price, String photopath, Customer customer){
    	//this.name = name;
    	this.name = name;
    	this.price = price;
    	
    	this.photopath = photopath;

    	
    	this.customer = customer;
    	
    }
    
    /*// name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }*/
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
    
    
    
    public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	// products
    public void setCompany(Customer customer){
    	this.customer = customer;
    }
    
  

	public Customer getCustomer(){
    	return this.customer;
    }
    
   

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/*public String toString(){
    	String info1 = "";
    //	String info2 = "";

    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject customerObj = new JSONObject();
        customerObj.put("name", this.customer.getName());
        
        jsonInfo.put("company", customerObj);
        
        info1 = jsonInfo.toString();
        
    //    info2 = jsonInfo.toString();

        
        System.out.println("info1 contain" +info1);
        return info1;
    }*/
	
	
	
	public String toString2(){
    	
    	String info2 = "";

    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject customerObj = new JSONObject();
        customerObj.put("photopath", this.customer.getPhoto());
        
        jsonInfo.put("cust", customerObj);
        
        info2 = jsonInfo.toString();
        
    //    info2 = jsonInfo.toString();

        
        System.out.println("info2 contain +" +info2);
        return info2;
    }
	
	

	
}
	
	



