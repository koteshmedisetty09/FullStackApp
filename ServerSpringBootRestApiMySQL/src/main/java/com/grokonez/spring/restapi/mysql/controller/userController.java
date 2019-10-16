


package com.grokonez.spring.restapi.mysql.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import com.grokonez.spring.restapi.mysql.model.User;
import com.grokonez.spring.restapi.mysql.model.items;
import com.grokonez.spring.restapi.mysql.repo.CartRepository;
import com.grokonez.spring.restapi.mysql.repo.CustomerRepository;
import com.grokonez.spring.restapi.mysql.repo.ItemRepositort;
import com.grokonez.spring.restapi.mysql.repo.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")

@RequestMapping("/api")
public class userController {

	
	
	 @Autowired
	    CartRepository cartRepository;
	     
	    @Autowired
	    UserRepository userRepository;
	

	
	
	
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers1() {
		List<User> users = new ArrayList<>();
		try {
			userRepository.findAll().forEach(users::add);
			System.out.println("in all cust");
		for (User user : users) {
			System.out.println(user);
		}
			
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			
			
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	@PostMapping(value = "/user")
	  public ResponseEntity<User>postUser(@RequestBody User user) {
		try {
		System.out.println("out"+user.getUsername());

	 
		//User _user = userRepository.save(new User(user.getUsername(), user.getPassword()));
		//System.out.println(_user.getUsername());
		
	  //  return _user;
	    
	    
	    
	    User _user = new User(user.getUsername(),user.getPassword() );
        
		 
		User _user1 = userRepository.save(_user);
	
		System.out.println("inside"+_user1.getUsername());
		
		//repository2.save(it1);
		return new ResponseEntity<>(_user1, HttpStatus.CREATED);
	}
	
	
	
 catch (Exception e) {
	 
	return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
}
	
	
	
	  }
	
	
	
	
	@RequestMapping(value= "/user/{username}/{password}", method= RequestMethod.GET)
    public ResponseEntity<User> doLogin(@PathVariable String username, @PathVariable String password ) {
	
		
		
		try {
			System.out.println("inside val");
	 
		
		List<User> user = (List<User>) userRepository.findAll();
		User validUser=null;
	
		for (User user2 : user) {
		

		System.out.println("userid in backedn  for is"	+user2.getUserid() );
			if(user2.getUsername().equals(username)  && user2.getPassword().equals(password) ) {
				
				validUser=user2;
				System.out.println("success");		
		     }
			System.out.println("out of if");
		}
		
		System.out.println("out of for");

		return new ResponseEntity<User>(validUser, HttpStatus.OK);
		
		}
		
      
		
	
		
	
	
	
      catch (Exception e) {
  		System.out.println("pwd in backedn catch dis" );

  		return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}
		

}
}