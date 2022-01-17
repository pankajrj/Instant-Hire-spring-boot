package com.instanthire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	private String customerEmail;
	private String customerName;
	private String customerPassword;
	private String customerContact;
	private String customerAddress;
	private String customerCity;
	private String customerAadharNumber;
	private String customerDOB;
	private String customerGender;
	

	public Customer() {
		super();
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerAadharNumber() {
		return customerAadharNumber;
	}

	public void setCustomerAadharNumber(String customerAadharNumber) {
		this.customerAadharNumber = customerAadharNumber;
	}

	public String getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerEmail=" + customerEmail + ", customerName="
				+ customerName + ", customerPassword=" + customerPassword + ", customerContact=" + customerContact
				+ ", customerAddress=" + customerAddress + ", customerCity=" + customerCity + ", customerAadharNumber="
				+ customerAadharNumber + ", customerDOB=" + customerDOB + ", customerGender=" + customerGender + "]";
	}

	

	
	
	
	

}
