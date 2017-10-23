package com.coach.app.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coach.app.dao.CoachRepository;
import com.coach.app.dao.UserRepository;
import com.coach.app.model.Coach;
import com.coach.app.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@Service
@Transactional ( propagation = Propagation.SUPPORTS,readOnly = true)

public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CoachRepository coachRepository;
	@Transactional
	public List<User> getAllUsers() {
		List<Object[]> objs = userRepository.findAllUsersOnly();
		
		
		List<User> users = new ArrayList<User>();
		for(Object[] objArray : objs) {
		   User user = new User(objArray);
		   users.add(user);
		}
		
		return users;
	}
	@Transactional ( propagation = Propagation.REQUIRED, readOnly = false)
	
	public void addUser(User user) {
		if(user.getCoaches() !=null) {
			Set<Coach> coaches = new HashSet<Coach>();
			for(Coach coach : user.getCoaches()) {
				Coach coachAdd = coachRepository.findById(coach.getId());
				coaches.add(coachAdd);
			}
			user.setCoaches(coaches);
		}
		userRepository.save(user);
	}

}
