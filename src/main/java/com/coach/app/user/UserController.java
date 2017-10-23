package com.coach.app.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.coach.app.model.User;


@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/users/user")
	public List<User> geALlUsers() {

		return userService.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/user")
	public String addUser(@RequestBody User user) {
		System.out.println("************************** " + user.toString());
		userService.addUser(user);
		return "Sucessful!";
	}
}
