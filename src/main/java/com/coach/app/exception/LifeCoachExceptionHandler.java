package com.coach.app.exception;



import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.ControllerAdvice;  
import org.springframework.web.bind.annotation.ExceptionHandler;  
import org.springframework.web.bind.annotation.ResponseStatus;  
import org.springframework.web.bind.annotation.RestController;  
  

@ControllerAdvice  
@RestController  
public class LifeCoachExceptionHandler {  
  
	@ExceptionHandler(value = ConstraintViolationException.class)  
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String constraintHandler(ConstraintViolationException ex){ 
		 StringBuilder messages = new StringBuilder();

		    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
		        messages.append(violation.getMessage() + "\n");
		    }

		    return messages.toString();
    }
    @ExceptionHandler(value = Exception.class)  
    public String handleException(Exception e){return e.getMessage();}  
  
  
}  
