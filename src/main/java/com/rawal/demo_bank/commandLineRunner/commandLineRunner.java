package com.rawal.demo_bank.commandLineRunner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rawal.demo_bank.entity.Customer;
import com.rawal.demo_bank.repository.CustomerRepository;

@Component
public class commandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
    public void run(String... args) throws Exception{
		Customer customer1 = new Customer(1, "John Doe", "john.doe@example.com", LocalDate.of(1990, 1, 1));
		Customer customer2 = new Customer(2, "Jane Smith", "jane.smith@example.com", LocalDate.of(1985, 2, 15));
		Customer customer3 = new Customer(3, "Alex Johnson", "alex.johnson@example.com", LocalDate.of(1995, 7, 10));
		Customer customer4 = new Customer(4, "Emily Davis", "emily.davis@example.com", LocalDate.of(1992, 4, 20));
		Customer customer5 = new Customer(5, "Michael Brown", "michael.brown@example.com", LocalDate.of(1988, 9, 5));
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		customerRepository.save(customer4);
		customerRepository.save(customer5);        
        
    }
}