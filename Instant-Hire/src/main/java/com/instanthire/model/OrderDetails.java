package com.instanthire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long hireId;
	private long employeeId;
	private long customerId;
    private String hireDate;
    private double basicSal;
    private double totalAmount;
    private String status;
    private String startTime;
    private String endTime;
	
	

	public OrderDetails() {
		super();
		this.hireDate = " ";
		this.basicSal = 0;
		this.totalAmount = 0;
		this.status = "undone";
		this.startTime = " ";
		this.endTime = " ";
	}

	public long getHireId() {
		return hireId;
	}

	public void setHireId(long hireId) {
		this.hireId = hireId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public double getBasicSal() {
		return basicSal;
	}

	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "OrderDetails [hireId=" + hireId + ", employeeId=" + employeeId + ", customerId=" + customerId
				+ ", hireDate=" + hireDate + ", basicSal=" + basicSal + ", totalAmount=" + totalAmount + ", status="
				+ status + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	
}
