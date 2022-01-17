package com.instanthire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePassword;
	private String employeeContact;
	private String employeeAadharNumber;
	private String employeeDOB;
	private String employeeAddress;
	private String employeeGender;
	private int professionId;
	private int employeeExperiance;
	private String employeeImage;
	private String employeeNOC;
	private String employeeCity;
	private int employeeRating;
	private double basicSal;
	
	
	
	public int getEmployeeRating() {
		return employeeRating;
	}

	public void setEmployeeRating(int employeeRating) {
		this.employeeRating = employeeRating;
	}

	public double getBasicSal() {
		return basicSal;
	}

	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	
	public Employee() {
		super();
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}

	public String getEmployeeAadharNumber() {
		return employeeAadharNumber;
	}

	public void setEmployeeAadharNumber(String employeeAadharNumber) {
		this.employeeAadharNumber = employeeAadharNumber;
	}

	public String getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(String employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public int getProfessionId() {
		return professionId;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public int getEmployeeExperiance() {
		return employeeExperiance;
	}

	public void setEmployeeExperiance(int employeeExperiance) {
		this.employeeExperiance = employeeExperiance;
	}

	public String getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}

	public String getEmployeeNOC() {
		return employeeNOC;
	}

	public void setEmployeeNOC(String employeeNOC) {
		this.employeeNOC = employeeNOC;
	}
	
	

	

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", employeePassword=" + employeePassword + ", employeeContact=" + employeeContact
				+ ", employeeAadharNumber=" + employeeAadharNumber + ", employeeDOB=" + employeeDOB
				+ ", employeeAddress=" + employeeAddress + ", employeeGender=" + employeeGender + ", professionId="
				+ professionId + ", employeeExperiance=" + employeeExperiance + ", employeeImage=" + employeeImage
				+ ", employeeNOC=" + employeeNOC + ", employeeCity=" + employeeCity + ", employeeRating="
				+ employeeRating + ", basicSal=" + basicSal + "]";
	}

	

	

	
	
	
	
	
	
	
	
}
