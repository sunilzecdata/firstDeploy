package com.example.demo.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    
	@Id
	@Column(length=16)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID uuid;
	@Column(name = "Company_Logo")
	private String company_Logo;
	@Column(length=250)
	private String companyBriefDescription;
	private String jobCategory;
	private String jobLocation;
	private String companySocialLink;
	@Column(length=255)
	private String companyAddress;
		
}
