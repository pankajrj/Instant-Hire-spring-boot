package com.instanthire.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instanthire.exeption.ResourceNotFoundException;
import com.instanthire.model.Employee;
import com.instanthire.model.OrderDetails;
import com.instanthire.repository.EmployeeRepository;
import com.instanthire.repository.OrderDetailsRepository;

@CrossOrigin
@RestController
@RequestMapping("/instanthire/order/")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	@GetMapping("/getallorder")
	public List<OrderDetails> getOrders(){
		return orderDetailsRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addorder")
	public OrderDetails addOrder(@RequestBody OrderDetails orderDetails) {
		LocalDate localDate = LocalDate.now();//For reference DateTimeFormatter
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy M dd");
		String formatdate=localDate.format(formatter);
		System.out.println(formatdate);
		String oldDate = formatdate;  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try{
			System.out.println("try loop");
			c.setTime(sdf.parse(oldDate));
			System.out.println("after try loop");
		}catch(ParseException e){
			
		 }
		String newDate = sdf.format(c.getTime());
		orderDetails.setHireDate(newDate);
		Employee emp=employeeRepository.findById(orderDetails.getEmployeeId()).orElseThrow(
				()->new ResourceNotFoundException("not found"));
		orderDetails.setBasicSal(emp.getBasicSal());
		System.out.println(orderDetails);
		return orderDetailsRepository.save(orderDetails);
	}
	
	@GetMapping("/getorderbycustid/{customerId}")
	 public List<OrderDetails> getOrderDetails(@PathVariable Long customerId){
		 return this.orderDetailsRepository.findByCustomerId(customerId);
	 }
	
	@CrossOrigin
	@PutMapping("/orderstart/{id}")
	public ResponseEntity<OrderDetails> startOrder(@PathVariable  long id,@RequestBody OrderDetails ord ) {
		System.out.println("id =============================================================================== "+id);
		OrderDetails od=orderDetailsRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee Data Not Available for id : " + id));
		LocalDate localDate = LocalDate.now();//For reference DateTimeFormatter
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy M dd");
		String formatdate=localDate.format(formatter);
		System.out.println(formatdate);
		String oldDate = formatdate;  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		try{
			System.out.println("try loop");
			c.setTime(sdf.parse(oldDate));
			System.out.println("after try loop");
		}catch(ParseException e){
			
		 }
		String newDate = sdf.format(c.getTime());
		od.setStartTime(newDate);
		od.setCustomerId(ord.getCustomerId());
		od.setEmployeeId(ord.getEmployeeId());
		od.setBasicSal(ord.getBasicSal());
		od.setHireDate(ord.getHireDate());
		od.setStatus("running");
		System.out.println("in startorder -> "+ord.getStartTime());
		System.out.println(od);	
		OrderDetails o=orderDetailsRepository.save(od); 
		return ResponseEntity.ok(o);
	}
	
	@GetMapping("getorder/{id}")
	public ResponseEntity<OrderDetails> getOrder(@PathVariable long id) {
		OrderDetails od=this.orderDetailsRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("not found"));
		return ResponseEntity.ok(od);
	}
	
	@SuppressWarnings("finally")
	@CrossOrigin
	@PutMapping("/orderend/{id}")
	public ResponseEntity<OrderDetails> endOrder(@PathVariable  long id,@RequestBody OrderDetails ord ) {
		OrderDetails od=orderDetailsRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee Data Not Available for id : " + id));
		try {
		System.out.println("id =============================================================================== "+id);
		
		LocalDate localDate = LocalDate.now();//For reference DateTimeFormatter
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy M dd");
		String formatdate=localDate.format(formatter);
		System.out.println(formatdate);
		String oldDate = formatdate;  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		try{
			System.out.println("try loop");
			c.setTime(sdf.parse(oldDate));
			System.out.println("after try loop");
		}catch(ParseException e){
			
		 }
		String newDate = sdf.format(c.getTime());
		od.setEndTime(newDate);
		od.setCustomerId(ord.getCustomerId());
		od.setEmployeeId(ord.getEmployeeId());
		od.setBasicSal(ord.getBasicSal());
		od.setHireDate(ord.getHireDate());
		od.setStartTime(ord.getStartTime());
		long diffInHours=0;
		 
            Date startDate = sdf.parse(od.getStartTime()); 
            Date endDate = sdf.parse(od.getEndTime()); 
           long duration  = endDate.getTime() - startDate.getTime();
           diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
           long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
           if(diffInMinutes > 30) {
        	   diffInHours+=1;
           }
           if(diffInHours ==0) {
        	   diffInHours=1;
           }
          		
		od.setTotalAmount(od.getBasicSal() * diffInHours);
		od.setStatus("done");
		System.out.println("in startorder -> "+ord.getEndTime());
		System.out.println(od);	
		
		
		 }
        catch (ParseException e) { 
            e.printStackTrace(); 
        } finally {
        	OrderDetails o=orderDetailsRepository.save(od); 
        	return ResponseEntity.ok(o);
        	
        }
	}	
	
	
	//get orderby empid
	@GetMapping("/getorderbyempid/{employeeId}")
	 public List<OrderDetails> getOrderDetailsemp(@PathVariable Long employeeId){
		 return this.orderDetailsRepository.findByEmployeeId(employeeId);
	 }
	
	@GetMapping("/rejectorder/{hireId}")
	 public List<OrderDetails> RejectOrderDetails(@PathVariable Long hireId){
		 OrderDetails od=this.orderDetailsRepository.findById(hireId).orElseThrow(
				()->new ResourceNotFoundException("not found"));
		 System.out.println("order ============> "+od);
		 od.setStatus("reject");
		 System.out.println("change status =================>"+od);
		 orderDetailsRepository.save(od);
		 return this.orderDetailsRepository.findByEmployeeId(od.getEmployeeId());
	 }
	
	
	@GetMapping("/getstatus/{id}")
	 public List<OrderDetails> getEmployeeByStatus(@PathVariable Long id){
		 return this.orderDetailsRepository.findByEmployeeIdAndStatus(id,"undone");
	 }
	
	
	
}
