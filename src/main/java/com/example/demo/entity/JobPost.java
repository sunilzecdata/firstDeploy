package com.example.demo.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobPost {
	
	@Id
	@Column(length=16)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID uuid;
	@Column(length=50)
	private String title;
	@Column(length=50)
	private String category;
	@Column(length=50)
	private String companyName;
	@Column(length=50)
	private String companyLogo;
	@Column(length=12)
	private Integer noOfVacancies;
	@Column(length=255)
	private String address;
	@Column(length=50)
	private String jobType;
    private Integer offeredSalary;
	@Column(length=500)
	private String requireKnowledgeSkills;
	@Column(length=100)
	private String education_qualification;
	private String status;
	@Column(length=250)
	private String description;
	@Column(length=12)
	private Integer contactNumber;
	private String emailAddress;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public Integer getNoOfVacancies() {
		return noOfVacancies;
	}
	public void setNoOfVacancies(Integer noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public Integer getOfferedSalary() {
		return offeredSalary;
	}
	public void setOfferedSalary(Integer offeredSalary) {
		this.offeredSalary = offeredSalary;
	}
	public String getRequireKnowledgeSkills() {
		return requireKnowledgeSkills;
	}
	public void setRequireKnowledgeSkills(String requireKnowledgeSkills) {
		this.requireKnowledgeSkills = requireKnowledgeSkills;
	}
	public String getEducation_qualification() {
		return education_qualification;
	}
	public void setEducation_qualification(String education_qualification) {
		this.education_qualification = education_qualification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
}
