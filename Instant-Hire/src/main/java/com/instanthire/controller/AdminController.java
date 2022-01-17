package com.instanthire.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instanthire.model.Admin;
import com.instanthire.repository.AdminRepository;

@RestController
@CrossOrigin
@RequestMapping("/instanthire/admin/")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping("/adminlist")
	public List<Admin> getAdminList(){
		return adminRepository.findAll();
	}
	
	@RequestMapping(value="addadmin",method=RequestMethod.POST)
	public Admin addAdmin(@RequestBody Admin admin) {
		System.out.println(admin);
		return adminRepository.save(admin);
	}
	
	@PostMapping("/checkadmin")
	public Admin adminLogin(@RequestBody Admin admin) {
		Admin a=adminRepository.findByAdminEmailAndAdminPass(admin.getAdminEmail(),admin.getAdminPass());
		if(Objects.nonNull(a)) {
			a.setAdminEmail("success");
			System.out.println("successfully login");
			return a;
		}else {
			a.setAdminEmail("fail");
			System.out.println("login failed");
			return a;
		}
		
	}
	
	@CrossOrigin
	@GetMapping("/getadmin/{emailId}")
	public Admin getCustomerByEmail(@PathVariable String emailId){
		Admin admin=adminRepository.findByAdminEmail(emailId);
		if(Objects.nonNull(admin)) {
//			cust.setCustomerEmail("success");
			System.out.println(admin);
			return admin;
		}else {
			System.out.println("admin not found");
			return null;
		}
		
	}
	
	@PostMapping("/sendKeyByEmailadmin")
	public Admin sendEmail(@RequestBody Admin apr) {
		 int randomPIN = (int)(Math.random()*9000)+1000;
		 
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
			System.out.println("customer object ======================================="+apr);
			Admin cust=adminRepository.findByAdminEmail(apr.getAdminEmail());
			cust.setSelfOTP(randomPIN);
			cust.setGeneratedOTP(randomPIN);
			System.out.println("After find"+cust);
			adminRepository.save(cust);
			String mail = cust.getAdminEmail();
			msg.setTo(mail);
			msg.setSubject("Instant-Hire Varification  OTP For Approval");
			msg.setText("Hello, "+cust.getAdminEmail()+" Your OTP for Registration Approval is "+cust.getGeneratedOTP()+"\n Your Regards - Instant-Hire");
			System.out.println("After Email====>>>>>"+cust);
			javaMailSender.send(msg);
			
			return cust;
	}

}
