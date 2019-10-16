

package com.grokonez.spring.restapi.mysql.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.spring.restapi.mysql.model.Cart;
import com.grokonez.spring.restapi.mysql.model.Customer;
import com.grokonez.spring.restapi.mysql.model.Info;
import com.grokonez.spring.restapi.mysql.model.User;
import com.grokonez.spring.restapi.mysql.model.items;
import com.grokonez.spring.restapi.mysql.repo.CartRepository;
import com.grokonez.spring.restapi.mysql.repo.CustomerRepository;
import com.grokonez.spring.restapi.mysql.repo.ItemRepositort;
import com.grokonez.spring.restapi.mysql.repo.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")

@RequestMapping("/api")
public class CartController {

	

	@Autowired
	ItemRepositort repository2;
	
	 @Autowired
	 CartRepository cartRepository;
	     
	 @Autowired
	  UserRepository userRepository;
	
	 
	 
	 
	 
	 
	/* 
	 
	
	@GetMapping("/cart/{userid}")
	public ResponseEntity<List<Cart>> getAllCarts(@PathVariable ("userid") int userid)  {
		System.out.println("came to cart back end");
		List<Cart> cart = new ArrayList<>();
		try {
			//cartRepository.findAll().forEach(cart::add);
			cartRepository.f  .findById(userid);
			System.out.println("user id in backend cart is" +cartRepository.findById((long) userid));

			System.out.println("inside cart of particular id");
		for (Cart cartlist : cart) {
			System.out.println(cartlist.getCart_id());
		}
			
			if (cart.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			
			
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	
	 @GetMapping("/cart/{userid}")
		public ResponseEntity<List<Cart>> getAllCarts(@PathVariable ("userid") long userid)  {
			List<Cart> cart = new ArrayList<>();
		 try {
				System.out.println("inside find by name");
				
		    cartRepository.findById(userid);   
				
System.out.println(cartRepository);
			cartRepository.findAll().forEach(cart::add);
	 
	 List<Cart>  pushelements=new ArrayList<>();

	 for (Cart cartlist : cart) {
			if(cartlist.getUser().getUserid() ==  userid  ) {
				
				pushelements.addAll(cart);
				
			}
			
		}		
				System.out.println("null value coming");
				 if (pushelements.isEmpty()) {
						System.out.println("empty value coming");

					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				 
				 
				 else {
					 
					
					 
			           for (Cart cartlist : pushelements) {
						System.out.println("xsdd"+cartlist.getProduct_name() +""+cartlist.getPrice()+""+cartlist.getCart_id() );
					}
					 
						return new ResponseEntity<>(pushelements, HttpStatus.OK);
				 }
				 
				 
					
				
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			}
		}
	 
	 
	 
	 
	 
	
	
	 
	 
	 
	 
	 
	 
	 
	
	 
	@PostMapping(value = "/cart")
	
	//  public ResponseEntity<Cart>postUser(@RequestBody items itemlist,@RequestBody int userid) {
	  public ResponseEntity<Cart>postUser(@RequestBody Info data) {

		
	try {
		
		
	//	json.get(userRepository.findById(user.getUserid()));

			System.out.println("inside cart ....");
			
			System.out.println("data is " +data);

			System.out.println("data id is " +data.userid);
			
			System.out.println("data price " +data.itemlist.getPrice());
			
			System.out.println("data pic path " +data.itemlist.getPhotopath());

			
			
			items itemlist=new items();
			itemlist=data.itemlist; 
       
		System.out.println(" backend value out"+itemlist );

	 
		User _user = new User();
		//System.out.println(_user.getUsername());
		
	  //  return _user;
	    //
		// User U1 = new User(U1.getUsername(),U1.getPassword() );

		  Cart _cart = new Cart(data.itemlist.getName() ,data.itemlist.getPrice(), data.itemlist.getPhotopath(),null );
      
	    List<User> user = (List<User>) userRepository.findAll();
		User validUser=null;
	
		for (User user2 : user) {
			

			
				if(user2.getUserid()==data.userid)    {
					
					validUser=user2;
					System.out.println("success in back");		
			     }
				
			}
	  

		_cart.setUser(validUser);
		cartRepository.save(_cart);
		//repository2.save(it1);
		return new ResponseEntity<>(_cart, HttpStatus.CREATED);
	}
	
	
	
catch (Exception e) {
	e.printStackTrace();
	return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
}
	
	 
	
	  }
	
	

	/*
	@PostMapping(value = "/cart")
	//  public ResponseEntity<Cart>postUser(@RequestBody items itemlist,@RequestBody int userid) {
	 public ResponseEntity<Cart>postUser(@RequestBody items itemlist) {
	try {

			System.out.println("inside cart");

		System.out.println("out"+itemlist.getName() );

	 
		User _user = new User();
		//System.out.println(_user.getUsername());
		
	  //  return _user;
	    //
		// User U1 = new User(U1.getUsername(),U1.getPassword() );

		 List<User> user = (List<User>) userRepository.findAll();
	    Cart _cart = new Cart(itemlist.getName() ,itemlist.getPrice(), itemlist.getPhotopath(),null );
      
	    
	   
	  		User validUser=null;
	  	
	  		for (User user2 : user) {
	  			

	  			
	  				if(user2.getUserid()==_user.getUserid())    {
	  					
	  					validUser=user2;
	  					System.out.println("success in back");		
	  			     }
	  				
	  			}
	  		
	  		_cart.setUser(validUser);
	  		cartRepository.save(_cart);
	    
	    
	    
	//    cartRepository.save(_cart);
		//repository2.save(it1);
		return new ResponseEntity<>(_cart, HttpStatus.CREATED);
	}
	
	
	
catch (Exception e) {
	return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
}
	
	 
	
	  }
		
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<HttpStatus> deleteCartItem(@PathVariable("id") long cart_id) {
		try {
			System.out.println(cart_id);
			cartRepository.deleteById(cart_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
}





