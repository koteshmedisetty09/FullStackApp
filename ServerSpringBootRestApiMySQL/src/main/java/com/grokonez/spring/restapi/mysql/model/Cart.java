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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.javasampleapproach.jpa.one2many.model.Product;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private int cart_id;
 
    @Column(name = "product_name")
    private String product_name;
 

    @Column(name = "price")
   	private int price;
    

    @Column(name = "image")
   	private String image;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userid", insertable = true,updatable=true)
  
    private User user;
    //private Set<items> items;
    public Cart() { }
 
    public Cart(String product_name,int price, String image,User user ) {
    	
        this.product_name = product_name;
        
        this.price = price;
        
        this.image = image;
        
        this.user = user;
        


    }

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPrice(int item_quantity) {
		this.price = item_quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getCart_id() {
		return cart_id;
	}


    
    
    
    
    
    
    
/*	public String toString() {
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
		
	}*/

	
	
	
	
	
	
}
