package com.rawal.demo_bank.service;

import java.util.List;

import com.rawal.demo_bank.Dto.CustomerDTO;
import com.rawal.demo_bank.exception.BankException;

public interface CustomerService {	
	public CustomerDTO getCustomer(Integer customerId) throws BankException;
	public List<CustomerDTO> getAllCustomers() throws BankException;
	public Integer addCustomer(CustomerDTO customer) throws BankException;
	public void updateCustomer(Integer customerId, CustomerDTO customer) throws BankException;
	public void deleteCustomer(Integer customerId) throws BankException;
}
