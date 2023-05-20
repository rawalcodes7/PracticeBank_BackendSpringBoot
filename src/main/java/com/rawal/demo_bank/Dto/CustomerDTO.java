package com.rawal.demo_bank.Dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class CustomerDTO {
	private Integer customerId;
	
	@Email(message="please provide valid email address")
	private String emailId;
	
	@NotNull(message = "Please provide customer name")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message="Name should contain only alphabets and space")
	private String name;
	
	@PastOrPresent(message = "Date of birth should be past or present date")
	private LocalDate dateOfBirth;
	
	
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
	public String toString() {
		return "Customer [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
