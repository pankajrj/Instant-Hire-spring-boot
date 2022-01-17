package com.instanthire.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instanthire.exeption.ResourceNotFoundException;
import com.instanthire.model.Customer;
import com.instanthire.repository.CustomerRepository;


@RestController
@CrossOrigin
@RequestMapping("/instanthire/cust/")
public class CustomerController{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private CustomerRepository custRepository;
	@CrossOrigin
	@GetMapping("/custlist")
	public List<Customer> getCustomerList(){
		return custRepository.findAll();
	}
	

	
	@RequestMapping(value="addcust",method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer cust) {
		return custRepository.save(cust);
	}
	
	@PostMapping("/checkcust")
	public Customer custLogin(@RequestBody Customer cust) {
		Customer c=custRepository.findByCustomerEmailAndCustomerPassword(cust.getCustomerEmail(),cust.getCustomerPassword());
		if(Objects.nonNull(c)) {
			c.setCustomerEmail("success");
			System.out.println("successfully login");
			return c;
		}else {
			c.setCustomerEmail("fail");
			System.out.println("login failed");
			return c;
		}
		
	}
	
	@CrossOrigin
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
		Customer cust=custRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("not found"));
		return ResponseEntity.ok(cust);
	}
	
	
	// Update Customers
	@CrossOrigin
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customerDetails){
		Customer customer = custRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer Data Not Available for id : " + id));
		
		customer.setCustomerName(customerDetails.getCustomerName());
		customer.setCustomerPassword(customerDetails.getCustomerPassword());
		customer.setCustomerEmail(customerDetails.getCustomerEmail());
		customer.setCustomerContact(customerDetails.getCustomerContact());
		customer.setCustomerDOB(customerDetails.getCustomerDOB());
		customer.setCustomerAadharNumber(customerDetails.getCustomerAadharNumber());
		customer.setCustomerAddress(customerDetails.getCustomerAddress());
		customer.setCustomerCity(customerDetails.getCustomerCity());
				
		
		
		Customer updatedCustomer = custRepository.save(customer);
		
		return ResponseEntity.ok(updatedCustomer);
		
	}
	
	// Delete customer 
	@CrossOrigin
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		Customer customer = custRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("customer Data Not Available for id : " + id));
		
		custRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@CrossOrigin
	@GetMapping("/getcustbyemail/{emailId}")
	public Customer getCustomerByEmail(@PathVariable String emailId){
		Customer cust=custRepository.findByCustomerEmail(emailId);
		if(Objects.nonNull(cust)) {
//			cust.setCustomerEmail("success");
			System.out.println(cust);
			return cust;
		}else {
			System.out.println("customer not found");
			return null;
		}
		
	}
	
	
	
	
	
	@PostMapping("/sendKeyByEmail")
	public Customer sendEmail(@RequestBody Customer apr) {
		SimpleMailMessage msg = new SimpleMailMessage();
			System.out.println("customer object ======================================="+apr);
			Customer cust=custRepository.findByCustomerEmail(apr.getCustomerEmail());
			System.out.println("After find"+cust);
			String mail = cust.getCustomerEmail();
			msg.setTo(mail);
			msg.setSubject("Instant-Hire Varification  OTP For Approval");
			msg.setText("Hello, "+cust.getCustomerEmail()+" Your OTP for Registration Approval is "+cust.getCustomerPassword()+"\n Your Regards - Instant-Hire");
			javaMailSender.send(msg);
			return cust;
	}
	
	
	
	
	
	
			
		
	
}
