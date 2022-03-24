package com.spring.security.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.app.domain.Customer;
import com.spring.security.app.service.FetchCustomerService;

@RestController
public class FetchCustomerData {
	
	private static final Logger log = LoggerFactory.getLogger(FetchCustomerData.class);
	
	@Autowired
	private FetchCustomerService fetchCustomerService;
	
	@RequestMapping(value="/customer/getCustomerName", method=RequestMethod.GET)
	//@PreAuthorize("hasRole('USER')")
	public String getCustomerName(@RequestBody Customer customer) {
		
		log.info("Print customer id:"+customer.getCustomerId());
		
		String customerName = fetchCustomerService.getCustomerNameById(customer.getCustomerId());
		
		log.info("Customer name is:"+customerName);
		
		return customerName;
		
	}
	
	@RequestMapping(value="/customer/addCustomer", method=RequestMethod.POST)
	//@PreAuthorize("hasRole('USER')")
	public String addCustomer(@RequestBody Customer customer) {
		
		return "ok";
		
	}
	
	@RequestMapping(value="/customer/getCustomerDetails", method=RequestMethod.GET)
	public Customer getCustomerDetails(@RequestBody Customer customer) {
		
		log.info("Print customer id:"+customer.getCustomerId());
		
		Customer c = fetchCustomerService.getCustomerDetailsById(customer.getCustomerId());
		
		return c;
		
	}

}
