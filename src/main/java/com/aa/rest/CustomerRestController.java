package com.aa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.entity.Customer;
import com.aa.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable int id) {
		Customer customer = service.findById(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Could not find any customer with ID: " + id);
		}
		
		return customer;
	}
	
	@PostMapping
	public Customer add(@RequestBody Customer customer) {
		customer.setId(0);
		
		service.save(customer);
		
		return customer;
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer customer) {
		service.save(customer);
		
		return customer;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id) {
		Customer customer = service.findById(id);
		
		if (customer == null ) {
			throw new CustomerNotFoundException("Could not find any customer with ID: " + id);
		}
		
		service.deleteById(id);
		
		return "The Customer with ID: " + id + " was deleted successfuly!";
	}

}
