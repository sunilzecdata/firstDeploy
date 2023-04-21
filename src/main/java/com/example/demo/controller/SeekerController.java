package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.example.custom.exception.BusinessException;
import com.example.demo.entity.Seeker;
import com.example.demo.service.SeekerService;

@RestController
@RequestMapping("seeker")
public class SeekerController {

	@Autowired
	SeekerService seekerService;

	@PostMapping("/add")
	public ResponseEntity<Seeker> addSeeker(@RequestBody Seeker seeker) {
		try {
			Seeker seekerSaved = seekerService.seekerAdd(seeker);
			return new ResponseEntity<Seeker>(seekerSaved, HttpStatus.CREATED);
		} 
		
		catch (BusinessException businessException) {
			return new ResponseEntity(businessException.getMessage(), HttpStatus.ALREADY_REPORTED);
			
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Seeker> getSeeker(@PathVariable Integer id) {
		try {
			Seeker retrievedSeeker = seekerService.seekerGetById(id);
			return new ResponseEntity<Seeker>(retrievedSeeker, HttpStatus.OK);
		} 
		
		catch (BusinessException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		 catch(Exception e) 
		{
			return new ResponseEntity(e,HttpStatus.BAD_GATEWAY);
		}
	}
	

	@GetMapping("/list")
	public ResponseEntity<List<Seeker>> showSeeker() {
	
			List<Seeker> list = seekerService.showSeeker();
			return new ResponseEntity<List<Seeker>>(list, HttpStatus.OK);
	}

	
	
	
	
	
	
	
//	@DeleteMapping("/delbyid/{id}")
//	public ResponseEntity<String> deleteSeeker(@PathVariable Integer id) {
//		try {
//			String msg = seekerService.seekerDeleteById(id);
//			return new ResponseEntity<String>(msg, HttpStatus.OK);
//		} catch (BusinessException e) {
//			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
//		} catch (Exception e) {
//			ControllerException ce = new ControllerException("500", "Something went wrong" + e.getMessage());
//			return new ResponseEntity<String>(HttpStatus.PRECONDITION_FAILED);
//		}
//
//	}

}
