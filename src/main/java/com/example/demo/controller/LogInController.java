package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Credential;
import com.example.demo.entity.Seeker;
import com.example.demo.service.SeekerService;

@RestController 
public class LogInController {
	
	@Autowired
	SeekerService seekerService;
	
	@CrossOrigin
	@PostMapping(path = "/login",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginSeeker(@RequestBody Credential credential)
	{
		String emailId=credential.getUserName();
		int password= credential.getPassword();
		Seeker seeker= seekerService.getByEmail(emailId);
		
			if(seeker !=null && emailId.equals(seeker.getEmail()) && password==seeker.getPass())
					{
				        return  new ResponseEntity<String>("Successfully logged_In--> "+seeker.getRole() ,HttpStatus.OK);
					}
		
		return new ResponseEntity<String>("Failed",HttpStatus.UNAUTHORIZED);
	}	
}

