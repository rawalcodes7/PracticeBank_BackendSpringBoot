package com.rawal.demo_bank.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rawal.demo_bank.Dto.CustomerDTO;



@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	
	public Customer(Integer id, String name, String emailId, LocalDate dob){
		this.customerId=id;
		this.emailId=emailId;
		this.name=name;
		this.dateOfBirth=dob;
	}
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Integer getCustomerId() {
	return customerId;
	}
	
	
	public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
	}
	public String getEmailId() {
	return emailId;
	}
	public void setEmailId(String emailId) {
	this.emailId = emailId;
	}
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public LocalDate getDateOfBirth() {
	return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
	}
	@Override
	public int hashCode() {
	return 31;
	}
	@Override
	public boolean equals(Object obj) {
	if (this == obj)
	return true;
	if (obj == null)
	return false;
	if (this.getClass() != obj.getClass())
	return false;
	CustomerDTO other = (CustomerDTO) obj;
	if (this.getCustomerId() == null) {
	if (other.getCustomerId() != null)
		return false;
	}
	else if (!this.getCustomerId().equals(other.getCustomerId()))
		return false;
	return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
