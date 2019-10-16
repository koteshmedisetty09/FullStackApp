package com.grokonez.spring.restapi.mysql.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.javasampleapproach.jpa.one2many.model.Product;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {


	@Id
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	@Transient
	private int price;

	@Column(name = "active")
	private boolean active;
	
	@Column(name = "itemname")
	private String itemname;
	
	

	@Column(name = "photo")
	private String photo;
	
	
    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<items> items;
    

	public Customer() {
	}

	public Customer(String name,String itemname,int price,String photo) {
		this.name = name;
	//	this.age = age;
		
		this.itemname = itemname;
		this.price = price;
		this.active = false;
		this.photo = photo;
	

	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	/*public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}*/

	

	public boolean isActive() {
		return active;
	}
	
	
	
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
	public Set<items> getItems() {
		return items;
	}

	public void setItems(Set<items> items) {
		this.items = items;
	}

	
	public String toString() {
		String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONArray itemArray = new JSONArray();
        if(this.items != null){
            this.items.forEach(item->{
                JSONObject subJson = new JSONObject();
              //  subJson.put("name", item.getName());
                
                subJson.put("name", item.getName());
                itemArray.put(subJson);
            });
        }
        jsonInfo.put("items", itemArray);
        info = jsonInfo.toString();
        return info;
		
	}

	
	
	
	
	
	
}
