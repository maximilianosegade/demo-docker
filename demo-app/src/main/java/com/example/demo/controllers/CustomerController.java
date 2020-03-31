package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return StreamSupport
				.stream(repository.findAll().spliterator(), false)
			    .collect(Collectors.toList());
	}
	
	@PostMapping
	public void newCustomer(@RequestBody Customer aCustomer) {
		System.out.println(aCustomer);
		repository.save(aCustomer);
	}
	
}
