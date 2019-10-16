package com.grokonez.spring.restapi.mysql.repo;


//package com.grokonez.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.spring.restapi.mysql.model.Cart;
import com.grokonez.spring.restapi.mysql.model.Customer;
import com.grokonez.spring.restapi.mysql.model.items;

public interface CartRepository extends CrudRepository<Cart, Long> {

	//Iterable<Cart> findAllById(int cart_id);

	//Cart findById(int id);
	//Cart findById(int id);
	
	
}
