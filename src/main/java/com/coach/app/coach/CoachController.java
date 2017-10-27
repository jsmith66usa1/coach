package com.coach.app.coach;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coach.app.model.Coach;


@RestController
public class CoachController {
	@Autowired
	CoachService coachService;

	@RequestMapping("/users/coaches/coach")
	public List<Coach> getAllCoaches() {

		return coachService.getAllCoaches();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/coaches/coach")
	public String addUser( @RequestBody Coach user) {
		
		coachService.addCoach(user);
		return "Sucessful!";
	}
	

	@ExceptionHandler(value = org.springframework.dao.DataIntegrityViolationException.class)  
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String IntegHandler(org.springframework.dao.DataIntegrityViolationException ex){ 
		 StringBuilder messages = new StringBuilder();
          if(ex.getRootCause() != null && ex.getRootCause().getMessage() != null) {
		    
		   if( ex.getRootCause().getMessage().toLowerCase().contains("duplicate")) {
			   return "Duplicate username";
		   }
          }
          return "Invalid coach";
    }  
	 
}
