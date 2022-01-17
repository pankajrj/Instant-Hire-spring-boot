package com.instanthire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FeedbackModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long feedbackId;
	private String emailId;
	private String msg;
	private long customerId;
	private long employeeId;
	public long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "FeedbackModel [feedbackId=" + feedbackId + ", emailId=" + emailId + ", msg=" + msg + ", customerId="
				+ customerId + ", employeeId=" + employeeId + "]";
	}
	
	
}
