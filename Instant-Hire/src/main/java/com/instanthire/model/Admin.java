package com.instanthire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminPass;
	private String adminEmail;
	private String adminContact;
	private int selfOTP;
	private int generatedOTP;
	
	

	public int getSelfOTP() {
		return selfOTP;
	}

	public void setSelfOTP(int selfOTP) {
		this.selfOTP = selfOTP;
	}

	public int getGeneratedOTP() {
		return generatedOTP;
	}

	public void setGeneratedOTP(int generatedOTP) {
		this.generatedOTP = generatedOTP;
	}

	public Admin() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPass=" + adminPass + ", adminEmail="
				+ adminEmail + ", adminContact=" + adminContact + ", selfOTP=" + selfOTP + ", generatedOTP="
				+ generatedOTP + "]";
	}

	
	
	
}
