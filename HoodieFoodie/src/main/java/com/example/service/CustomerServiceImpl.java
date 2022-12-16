package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exceptions.CustomerException;
import com.example.model.Address;
import com.example.model.Customer;
import com.example.model.Restaurant;
import com.example.repository.CustomerDao;


public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerException("Customer Already Exist ....");
		}
		
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return customerDao.save(customer);
		}
		throw new CustomerException("No Customer Exist with this Data");
	}

//	@Override
//	public Customer removeCustomer(String id) throws CustomerException {
//		Optional<Customer> opt = customerDao.findById(id);
//		if(opt.isPresent()) {
//			customerDao.delete(opt.get());
//			return opt.get();
//		}
//		throw new CustomerException("No Customer Exist");
//	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> customer1= customerDao.findById(customer.getCustomerId());
		if(customer1.isPresent()) {
			Customer existC=customer1.get();
			customerDao.delete(customer);
			
			return existC;
		}
	throw new CustomerException("No Customer Exist");
		
	}

	@Override
	public Customer viewCustomer(Customer customer) throws CustomerException {
		return customerDao.findById(customer.getCustomerId()).orElseThrow(()-> new CustomerException("Customer not Found"));
	}
//	@Override
//	public Customer viewCustomer(String cID) throws CustomerException {
//		Optional<Customer> opt = customerDao.findById(cID);
//		if(opt.isPresent()) {
//			return opt.get();
//		}
//		throw new CustomerException("No Customer Exist");
//	}

	@Override
	public List<Customer> viewAllCustomer(Restaurant rest) throws CustomerException {
		// TODO Auto-generated method stub
List<Customer> customers=customerDao.findByAddress(rest.getAddress());

if(customers.isEmpty()) {
	throw new CustomerException("Customer Not find");
}
		return customers;
	}


	

}