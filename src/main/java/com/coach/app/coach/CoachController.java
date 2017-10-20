package com.coach.app.coach;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String addUser(@RequestBody Coach user) {
		System.out.println("************************** " + user);
		coachService.addCoach(user);
		return "Sucessful!";
	}
}
