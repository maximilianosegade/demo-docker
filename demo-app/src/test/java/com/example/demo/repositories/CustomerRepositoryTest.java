package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Customer;

@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository repository;
	
	@Test
	public void findNonExistingCustomer() {
		assertEquals(Optional.empty(), repository.findById(1L));
	}
	
	@Test
	public void findExistingCustomer() {
		Customer newCustomer = Customer.builder()
				.firstName("Diego")
				.lastName("Maradona")
				.build();
		
		newCustomer = repository.save(newCustomer);
		
		assertEquals(repository.count(), 1L);
		assertTrue(repository.findById(newCustomer.getId()).isPresent());
	}

}
