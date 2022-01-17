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
import com.instanthire.model.Employee;
import com.instanthire.repository.EmployeeRepository;



@RestController
@CrossOrigin
@RequestMapping("/instanthire/employee/")
public class EmployeeController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	@CrossOrigin
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(value="addemployee",method=RequestMethod.POST)
	public Employee addAdmin(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@CrossOrigin
	@PostMapping("checkemployee")
	public Employee checkEmployee(@RequestBody Employee emp) {
		Employee e=employeeRepository.findByEmployeeEmailAndEmployeePassword(emp.getEmployeeEmail(),emp.getEmployeePassword());
		if(Objects.nonNull(e)) {
			System.out.println("login success");
			e.setEmployeeEmail(emp.getEmployeeEmail());
			return e;
		}else {
			System.out.println("login succesfailed");
			e.setEmployeeEmail(" ");
			return e;
			
		}
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee emp=employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("not found"));
		return ResponseEntity.ok(emp);
	}
	
	@CrossOrigin
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Data Not Available for id : " + id));
		
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setEmployeePassword(employeeDetails.getEmployeePassword());
		employee.setEmployeeAadharNumber(employeeDetails.getEmployeeAadharNumber());
		employee.setEmployeeAddress(employeeDetails.getEmployeeAddress());
		employee.setEmployeeCity(employeeDetails.getEmployeeCity());
		employee.setEmployeeContact(employeeDetails.getEmployeeContact());
		employee.setEmployeeDOB(employeeDetails.getEmployeeDOB());
		employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
		employee.setEmployeeExperiance(employeeDetails.getEmployeeExperiance());
		employee.setEmployeeImage(employeeDetails.getEmployeeImage());
		employee.setEmployeeNOC(employeeDetails.getEmployeeNOC());
		employee.setProfessionId(employeeDetails.getProfessionId());
		employee.setEmployeeRating(employeeDetails.getEmployeeRating());
		employee.setBasicSal(employeeDetails.getBasicSal());
		
		
		
		Employee updatedEmployee = employeeRepository.save(employee);
		
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	
	// Delete Employee 
	@CrossOrigin
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Data Not Available for id : " + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	//get employee by profession
	@GetMapping("/employeebyprofession/{id}")
	@CrossOrigin
	public List<Employee> getEmployeesbyProfession(@PathVariable int id){
		return employeeRepository.findByProfessionId(id);
	}
	
	@CrossOrigin
	@GetMapping("/getempbyemail/{emailId}")
	public Employee getEmployeeByEmail(@PathVariable String emailId){
		Employee emp=employeeRepository.findByEmployeeEmail(emailId);
		if(Objects.nonNull(emp)) {
//			cust.setCustomerEmail("success");
			System.out.println(emp);
			return emp;
		}else {
			System.out.println("customer not found");
			return null;
		}
		
	}
	
	@GetMapping("/empbyrating")
	@CrossOrigin
	public List<Employee> getEmployeesbyRating(){
		return employeeRepository.findByEmployeeRating(0);
	}
	
	@PostMapping("/sendKeyByEmailee")
	public Employee sendEmail(@RequestBody Employee apr) {
		SimpleMailMessage msg = new SimpleMailMessage();
			System.out.println("customer object ======================================="+apr);
			Employee cust=employeeRepository.findByEmployeeEmail(apr.getEmployeeEmail());
			System.out.println("After find"+cust);
			String mail = cust.getEmployeeEmail();
			msg.setTo(mail);
			msg.setSubject("Instant-Hire Varification  OTP For Approval");
			msg.setText("Hello, "+cust.getEmployeeEmail()+" Your OTP for Registration Approval is "+cust.getEmployeePassword()+"\n Your Regards - Instant-Hire");
			javaMailSender.send(msg);
			return cust;
	}
	
	@GetMapping("/getempbycity/{city}")
	public List<Employee> getEmployeeByCity(@PathVariable String city){
		return employeeRepository.findByEmployeeCity(city);
		
	}

		


}
