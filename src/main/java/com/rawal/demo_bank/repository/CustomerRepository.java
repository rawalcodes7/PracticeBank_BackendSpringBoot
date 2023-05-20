package com.rawal.demo_bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rawal.demo_bank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
