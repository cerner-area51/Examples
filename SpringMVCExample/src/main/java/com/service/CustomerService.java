package com.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Customer;
import com.respository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PersistenceContext
    private EntityManager em;

	
	public Customer findCustomerByName(String name){
		return customerRepository.findByName(name);
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer>customers = customerRepository.findAll();
		return customers;
	}
	//this performs both create and update
	public void saveCustomer(Customer customer){
		customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomersByCity(String city){
		List<Customer>customers = customerRepository.findByCity(city);
		return customers;
	}
	
	public void deleteCustomer(Customer customer){
		customerRepository.delete(customer);
	}
	
	public Customer getCustomerById(int id){
		return customerRepository.findById(id);
	}

}