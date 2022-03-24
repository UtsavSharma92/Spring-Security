package com.spring.security.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.app.domain.Customer;
import com.spring.security.app.repository.CustomerRepository;

@Service
public class FetchCustomerService {

	private static final Logger log = LoggerFactory.getLogger(FetchCustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	public Customer getCustomerDetailsById(int id) {

		log.info("Entered getCustomerDetails:");

		Customer customer = customerRepository.findByCustomerId(id);

		return customer;

	}

	public String getCustomerNameById(int id) {

		log.info("Entered getCustomerName:");

		Customer customer = customerRepository.findByCustomerId(id);

		log.info("Get customer name returned from repository method:" + customer.getCustomerName());

		return customer.getCustomerName();

	}

}
