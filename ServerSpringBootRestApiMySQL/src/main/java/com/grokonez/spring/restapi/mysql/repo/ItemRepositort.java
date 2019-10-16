  package com.grokonez.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.spring.restapi.mysql.model.items;

public interface ItemRepositort extends CrudRepository<items, Integer> {
	items findByName(String name);
List<items>	findAll();
}
