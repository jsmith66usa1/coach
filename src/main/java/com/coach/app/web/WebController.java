package com.coach.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	


		@RequestMapping(value="/users",method = RequestMethod.GET)
	    public String userPage(){
	        return "user_web";
	    }
		@RequestMapping(value="/users/coaches",method = RequestMethod.GET)
	    public String coachPage(){
	        return "coach_web";
	    }
}