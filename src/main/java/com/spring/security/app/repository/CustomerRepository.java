package com.spring.security.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.app.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	public Customer findByCustomerId(int id);

}
