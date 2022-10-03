package com.glx.app.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glx.app.dto.Customer;
import com.glx.app.exception.GlxException;
import com.glx.app.services.CustomerServices;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServices customerService;

	@PostMapping("customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) throws GlxException {
		Customer customerAdded = null;
		customerAdded = customerService.addCustomer(customer);
		return customerAdded;
	}

	@GetMapping("customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") Integer id) throws GlxException {
		Optional<Customer> customerFound = null;
		customerFound = customerService.getCustomerById(id);
		return customerFound;
	}

	@PutMapping("customer")
	public Customer updateCustomer(@RequestBody Customer customer) throws GlxException {
		Customer customerUpdated = null;
		customerUpdated = customerService.updateCustomer(customer);
		return customerUpdated;
	}

	@DeleteMapping("customer/{id}")
	public String deleteCustomerById(@PathVariable("id") Integer id) throws GlxException {
		String msg = null;
		if (customerService.deleteCustomerById(id))
			msg = "Delete Successfull";
		return msg;
	}

//	@GetMapping("customers")
//	public List<Customer> getAllCustomers() throws GlobalMartException {
//		List<Customer> customers = null;
//		customers = customerService.getAllCustomers();
//		return customers;
//	}

}