package com.example.demo.entity;

import java.util.UUID;

import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID uuid;
	@Column(length = 50)
	private String fName;
	@Column( length = 50)
	private String lName;
	@Column(length = 55)
	private String email;
	@Column(length = 12)
	private Integer mobileNo;
	@Column(length = 100)
	private String colComName;
	private String address;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	public String getColComName() {
		return colComName;
	}
	public void setColComName(String colComName) {
		this.colComName = colComName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
