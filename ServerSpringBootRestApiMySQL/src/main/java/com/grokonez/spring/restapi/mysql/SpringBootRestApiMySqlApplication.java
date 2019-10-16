package com.grokonez.spring.restapi.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grokonez.spring.restapi.mysql.model.Customer;
import com.grokonez.spring.restapi.mysql.model.items;
import com.grokonez.spring.restapi.mysql.repo.CartRepository;
import com.grokonez.spring.restapi.mysql.repo.CustomerRepository;
//import com.grokonez.spring.restapi.mysql.repo.ItemRepositort;
import com.grokonez.spring.restapi.mysql.repo.ItemRepositort;
import com.grokonez.spring.restapi.mysql.repo.UserRepository;

import java.util.HashSet;
import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SpringBootApplication
public class SpringBootRestApiMySqlApplication implements CommandLineRunner{
	 
    @Autowired
    CustomerRepository customerRepository;
     
    @Autowired
    ItemRepositort itemRepositort;
    
    @Autowired
    CartRepository cartRepository;
     
    @Autowired
    UserRepository userRepository;
     
    
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
 
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
 
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
    public static void main(String[] args) {
    	SpringApplication.run(SpringBootRestApiMySqlApplication.class, args);
    }
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}


		
	}
 

  /*  @Override
    public void run(String... arg0) throws Exception {
    	clearData();
    	saveData();
    	showData();
    }
    
   @Transactional
    private void clearData(){
    	customerRepository.deleteAll();
    	itemRepositort.deleteAll();
    }
    
    @Transactional
    private void saveData(){
    	saveDataWithApproach1();
    }
    
    *//**
     * Save Company objects that include Product list
     *//*
    private void saveDataWithApproach1(){
        Customer C1 = new Customer("nani",24 );
        Customer c2 = new Customer("mani",29 );
        
        items iphone7 = new items(C1.getName(), C1);
        items iPadPro = new items("IPadPro", c2);
        
        items galaxyJ7 = new items("GalaxyJ7", c2);
        items galaxyTabA = new items("GalaxyTabA", C1);
        
        C1.setItems(new HashSet<items>(){{
            add(iphone7);
            add(iPadPro);
        }});
        
        c2.setItems(new HashSet<items>(){{
            add(galaxyJ7);
            add(galaxyTabA);
        }});
        
        // save companies
        customerRepository.save(C1);
        customerRepository.save(c2);
    }
    
    
    *//**
     * Save company first (not include product list). Then saving products which had attached a company for each.  
     *//*
    private void saveDataWithApproach2(){
    	
    	
    	 * Firstly persist companies (not include product list)
    	 
        Company apple = new Company("Apple");
        Company samsung = new Company("Samsung");
        
        //save companies
        companyRepository.save(apple);
        companyRepository.save(samsung);
        
        
         * Then store products with had persisted companies.
         
    	Product iphone7 = new Product("Iphone 7", apple);
        Product iPadPro = new Product("IPadPro", apple);
        
        Product galaxyJ7 = new Product("GalaxyJ7", samsung);
        Product galaxyTabA = new Product("GalaxyTabA", samsung);
 
        // save products
        productRepository.save(iphone7);
        productRepository.save(iPadPro);
        
        productRepository.save(galaxyJ7);
        productRepository.save(galaxyTabA);
    }
    
    @Transactional
    private void showData(){
    	// get All data
    	List<Customer> companyLst = (List<Customer>) customerRepository.findAll();
        List<items> productLst = (List<items>) itemRepositort.findAll();
         
        System.out.println("===================Product List:==================");
        productLst.forEach(System.out::println);
         
        System.out.println("===================Company List:==================");
        companyLst.forEach(System.out::println);
    }
}



*/