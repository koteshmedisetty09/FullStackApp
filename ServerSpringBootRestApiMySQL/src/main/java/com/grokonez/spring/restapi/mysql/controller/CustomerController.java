package com.grokonez.spring.restapi.mysql.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.spring.restapi.mysql.model.Customer;
import com.grokonez.spring.restapi.mysql.model.items;
import com.grokonez.spring.restapi.mysql.repo.CustomerRepository;
import com.grokonez.spring.restapi.mysql.repo.ItemRepositort;





//@Access-Control-Allow-Origin: *


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	

	@Autowired
	ItemRepositort repository2;
	

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		try {
			repository.findAll().forEach(customers::add);
			System.out.println("in all cust");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
			
			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			
			
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		Optional<Customer> customerData = repository.findById((int) id);

		if (customerData.isPresent()) {
			return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
*/
	@PostMapping(value = "/customers")
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
		try {
			
		//	Customer existingCustomer = repository.findByName(customer.getName());
					
			
			 //Customer C1 = new Customer(customer.getName(), customer.getAge(),customer.getItemname() );
			
			if(repository.findByName(customer.getName())!=null)
			{
		if(repository.findByName(customer.getName()).getName().equalsIgnoreCase(customer.getName())) {
			
			System.out.println(customer);
			System.out.println("quantity in if" +customer.getPrice());

			  items it1 = new items(customer.getItemname(),customer.getPrice(),customer.getPhoto(), repository.findByName(customer.getName()));
			  System.out.println("items saved" +it1);

			  repository2.save(it1);
			  
			
		}
		
		return new ResponseEntity<>(repository.findByName(customer.getName()), HttpStatus.CREATED);
			}
		else {
			 Customer C1 = new Customer(customer.getName(),customer.getItemname(),customer.getPrice(),customer.getPhoto() );
		        
			  items it1 = new items(C1.getItemname(),C1.getPrice(),C1.getPhoto(), C1);
			  System.out.println("items saved" +it1);
			  System.out.println("quantity detals" +customer.getPrice());
			Customer _customer = repository.save(C1);
		
			
			repository2.save(it1);
			return new ResponseEntity<>(_customer, HttpStatus.CREATED);
		}
			
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping ("/customers/{id}")
	public ResponseEntity<Customer> editCustomer(@PathVariable("id") long id, @RequestBody Customer customer  ){
		try {
			
			//	Customer existingCustomer = repository.findByName(customer.getName());
						
				
				 //Customer C1 = new Customer(customer.getName(), customer.getAge(),customer.getItemname() );
				
				if(repository.findByName(customer.getName())!=null)
				{
			if(repository.findByName(customer.getName()).getName().equalsIgnoreCase(customer.getName())) {
				System.out.println("byebyebabu");
				System.out.println(customer);
				System.out.println("quantity in if" +customer.getPrice());

				  items it1 = new items(customer.getItemname(),customer.getPrice(),customer.getPhoto(), repository.findByName(customer.getName()));
				  repository2.save(it1);
				  
				
			}
			
			return new ResponseEntity<>(repository.findByName(customer.getName()), HttpStatus.CREATED);
				}
			else {
				 Customer C1 = new Customer(customer.getName(),customer.getItemname(),customer.getPrice(),customer.getPhoto() );
			        
				  items it1 = new items(C1.getItemname(),C1.getPrice(),C1.getPhoto(), C1);
				  System.out.println("quantity detals" +customer.getPrice());
				Customer _customer = repository.save(C1);
			
				
				repository2.save(it1);
				return new ResponseEntity<>(_customer, HttpStatus.CREATED);
			}
				
				
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			}
	}
	
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
		try {
			repository.deleteById((int) id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	
	

	@DeleteMapping("/customers")
	public ResponseEntity<HttpStatus> deleteAllCustomers() {
		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	/*@GetMapping(value = "customers/age/{age}")
	public ResponseEntity<List<Customer>> findByAge(@PathVariable int age) {
		try {
			List<Customer> customers = repository.findByAge(age);

			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}*/
	
	
	@GetMapping(value = "customers/items/{name}")
	public ResponseEntity findByName(@PathVariable String name) {
		try {
			System.out.println("inside find by name");
			
		Customer customer =     repository.findByName(name);
			

 List<items> allitems=repository2.findAll();
 
 List<items>  pushelements=new ArrayList<>();

	for (items items : allitems) {
		if(items.getCustomer().getId()==customer.getId()) {
			
			pushelements.add(items);
			
		}
		
	}		
			System.out.println("null value coming");
			 if (pushelements.isEmpty()) {
					System.out.println("empty value coming");

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			 
			 
			 else {
				 
				
				 
		           for (items items : pushelements) {
					System.out.println("xsdd"+items.getName()+""+items.getPrice());
				}
				 
					return new ResponseEntity<>(pushelements, HttpStatus.OK);
			 }
			 
			 
				
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	
	
	
	

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		Customer customerData= repository.findById((int) id);
		System.out.println("backend"+customerData);
		
		if(repository.findByName(customer.getName())== null) {
		
		
		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} else {
					
								
					
					
					Customer _customer = repository.findById((int) id);
					_customer.setName(customer.getName());
					
					_customer.setActive(customer.isActive());
					
					
					return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	@GetMapping("/items")
	public ResponseEntity<List<items>> getAllItems() {
		List<items> models = new ArrayList<>();
		try {
			repository2.findAll().forEach(models::add);
			System.out.println("in all cust");
		for (items items : models) {
			System.out.println(items);
		}
			
			if (models.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			
			
			return new ResponseEntity<>(models, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
