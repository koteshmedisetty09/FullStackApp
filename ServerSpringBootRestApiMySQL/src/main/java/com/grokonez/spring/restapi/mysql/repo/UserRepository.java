package com.grokonez.spring.restapi.mysql.repo;

//package com.grokonez.spring.restapi.mysql.repo;


//package com.grokonez.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.spring.restapi.mysql.model.Customer;
import com.grokonez.spring.restapi.mysql.model.User;
import com.grokonez.spring.restapi.mysql.model.items;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	//User findByUserName(String name); 
	//User findById(int id);
}
