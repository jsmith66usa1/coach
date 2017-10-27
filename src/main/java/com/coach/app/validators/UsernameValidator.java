package com.coach.app.validators;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
public class UsernameValidator implements ConstraintValidator<Username, String> {
    public void initialize(Username constraintAnnotation) {
 
    }
 
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value !=null && value.contains("?")) {
            return false;
        }
        return true;
    }
}
