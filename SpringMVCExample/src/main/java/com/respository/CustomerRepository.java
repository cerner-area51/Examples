package com.respository;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

	Customer findByName(String name);
	
	List<Customer>findAll();
	//@Query("")
	List<Customer> findByCity(String city);
	
	@Query("from Customer where customerId= ?")//JPA-QL
	Customer findById(int id);
}