package com.rawal.demo_bank.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rawal.demo_bank.Dto.CustomerDTO;
import com.rawal.demo_bank.exception.BankException;
import com.rawal.demo_bank.exception.ErrorInfo;
import com.rawal.demo_bank.service.CustomerService;

@RestController
@RequestMapping(value="/practiceBank")
public class CustomerAPI {
	
	
	@Autowired
	private CustomerService customerService;
	
//	@Autowired
//	private Environment environment;
	
	@GetMapping(value="/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws BankException {
		List<CustomerDTO> customerList = customerService.getAllCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws BankException {
		CustomerDTO customer = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	//Other way of handling exceptions form controller itself (after spring 5) is following :-
	
//	@GetMapping(value = "/customers/{customerId}")
//	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws BankException {
//			try {
//				CustomerDTO customerDTO = customerService.getCustomer(customerId);
//				return new ResponseEntity<>(customerDTO, HttpStatus.OK);
//			} catch (Exception exception) {
//				throw new ResponseStatusException(HttpStatus.NOT_FOUND,new String("Customer not found!"));
//			}
//	}

	
	@PostMapping(value = "/customers")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customer) throws BankException {
		Integer customerId = customerService.addCustomer(customer);
		String successMessage = "Customer created successfully with cusomer ID: "+ customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	@PutMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId,@Valid @RequestBody CustomerDTO customer)
			throws BankException {
		customerService.updateCustomer(customerId, customer);
		String successMessage = "Customer updated Successfully!";
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@DeleteMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws BankException {
		customerService.deleteCustomer(customerId);
		String successMessage = "CUSTOMER DELETED!";
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		    errorInfo.setTimestamp(LocalDateTime.now());
			
			String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
			errorInfo.setErrorMessage(errorMsg);
		
			return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}	    

	
}



