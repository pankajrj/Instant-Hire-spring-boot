package com.instanthire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profession")
public class Profession {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long professionId;
	private String professionName;
	private double professionAmount;
	private String professionDescription;
	public Profession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getProfessionId() {
		return professionId;
	}
	public void setProfessionId(long professionId) {
		this.professionId = professionId;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getProfessionDescription() {
		return professionDescription;
	}
	public void setProfessionDescription(String professionDescription) {
		this.professionDescription = professionDescription;
	}
	public double getProfessionAmount() {
		return professionAmount;
	}
	public void setProfessionAmount(double professionAmount) {
		this.professionAmount = professionAmount;
	}
	@Override
	public String toString() {
		return "Profession [professionId=" + professionId + ", professionName=" + professionName + ", professionAmount="
				+ professionAmount + ", professionDescription=" + professionDescription + "]";
	}
	
	
	
	
	

}
