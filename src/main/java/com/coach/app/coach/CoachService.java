package com.coach.app.coach;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coach.app.dao.CoachRepository;
import com.coach.app.model.Coach;
import com.coach.app.model.User;
@Service
@Transactional ( propagation = Propagation.SUPPORTS, readOnly = true)
public class CoachService {
	@Autowired
	private CoachRepository coachRepository;


	@Transactional
	public List<Coach> getAllCoaches() {
		List<Object[]> objs = coachRepository.findAllCoachsOnly();
		
		
		List<Coach> coaches = new ArrayList<Coach>();
		for(Object[] objArray : objs) {
		   Coach coach = new Coach(objArray);
		   coaches.add(coach);
		}
		
		return coaches;
	}
	@Transactional ( propagation = Propagation.REQUIRED, readOnly = false)
	public void addCoach(Coach coach) {
		coachRepository.save(coach);
	}

}
