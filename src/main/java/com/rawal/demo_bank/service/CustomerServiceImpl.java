package com.rawal.demo_bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rawal.demo_bank.Dto.CustomerDTO;
import com.rawal.demo_bank.entity.Customer;
import com.rawal.demo_bank.exception.BankException;
import com.rawal.demo_bank.repository.CustomerRepository;

@Service(value="CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	
	//we don't wish to expose our Customer entity directly rather a layer of it, which is the CustomerDTO here!
	public CustomerDTO getCustomer(Integer customerId) throws BankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new BankException("CUSTOMER NOT FOUND"));
		
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId(customer.getCustomerId());
		customer2.setDateOfBirth(customer.getDateOfBirth());
		customer2.setEmailId(customer.getEmailId());
		customer2.setName(customer.getName());
		
		return customer2;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() throws BankException {
		Iterable<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customers2 = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerId(customer.getCustomerId());
			cust.setDateOfBirth(customer.getDateOfBirth());
			cust.setEmailId(customer.getEmailId());
			cust.setName(customer.getName());
			customers2.add(cust);
		});
		if (customers2.isEmpty())
			throw new BankException("CUSTOMERS NOT FOUND");
		return customers2;
	}

	@Override
	public Integer addCustomer(CustomerDTO customer) throws BankException {
		
		// with the help of received customerDTO , create a new Customer entity and with the
		// help of customerReopositoyr, store it in our database.
		Customer customerEntity = new Customer();
		customerEntity.setDateOfBirth(customer.getDateOfBirth());
		customerEntity.setEmailId(customer.getEmailId());
		customerEntity.setName(customer.getName());
		customerEntity.setCustomerId(customer.getCustomerId());
		Customer customerEntity2 = customerRepository.save(customerEntity);
		return customerEntity2.getCustomerId();
	}

	@Override
	public void updateCustomer(Integer customerId, CustomerDTO customer) throws BankException {
		Optional<Customer> optional= customerRepository.findById(customerId);
		Customer updatedCustomer=optional.orElseThrow(()->new BankException("Customer not found"));
		updatedCustomer.setEmailId(customer.getEmailId());
		updatedCustomer.setDateOfBirth(customer.getDateOfBirth());
		updatedCustomer.setName(customer.getName());
	}

	@Override
	public void deleteCustomer(Integer customerId) throws BankException {
		Optional<Customer> optional= customerRepository.findById(customerId);
		optional.orElseThrow(()->new BankException("CUSTOMER NOT FOUND"));
		customerRepository.deleteById(customerId);
	}
	
}
	

