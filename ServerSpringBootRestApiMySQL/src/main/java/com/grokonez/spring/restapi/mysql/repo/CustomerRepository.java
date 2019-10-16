package com.grokonez.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.spring.restapi.mysql.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	//List<Customer> findByAge(int age);
	
	Customer findById(int id);
	
	Customer findByName(String name); 
	
		
	
	
	
}
