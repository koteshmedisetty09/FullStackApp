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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.grokonez.springrestapi.onetoone.model.Contact;

//import com.javasampleapproach.jpa.one2many.model.Product;

@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private long userid;

	@Column(name = "username")
	private String username;

	
	@Column(name = "password")
	private String password;
	

   // @JsonManagedReference
   // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
   // private Set<Cart> cart;
    
  //  private Cart cart;


	public User() {
	} 

	public User(String username,String password) {
		this.username = username;
	//	this.age = age;
		
		this.password = password;
		
	

	}

	






	public long getUserid() {
		return userid;
	}

	



	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}





	public String toString() {
		String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("username",this.username);
        jsonInfo.put("password",this.password);
        
       
        
       // jsonInfo.put("items", itemArray);
        info = jsonInfo.toString();
        return info;
		
	}

	
	
	
	
	
	
}
