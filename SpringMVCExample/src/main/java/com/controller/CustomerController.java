package com.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value="/All",method=RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}

	@RequestMapping(value="SAVE",method=RequestMethod.POST)	
	public String save(Customer customer){
		customerService.saveCustomer(customer);
		return "success";
	}

	@RequestMapping(value="/city/{name}",method=RequestMethod.GET)	
	public List<Customer> getCustomerByCity(@PathVariable("name") String name){
		return customerService.getAllCustomersByCity(name);
	}
	
	@RequestMapping(value="/city",method=RequestMethod.GET)	
	public List<Customer> getCustomerByCityUsingReqParam(@RequestParam("name") String name){
		return customerService.getAllCustomersByCity(name);
	}

	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Customer getById(@PathVariable("id") Integer id){		
		return customerService.getCustomerById(id);
	}
		

}