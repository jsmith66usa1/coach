package com.coach.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.coach.app.model.Coach;




// This will be AUTO IMPLEMENTED by Spring into a Bean called coachRepository
// CRUD refers Create, Read, Update, Delete
@Transactional
public interface CoachRepository extends CrudRepository<Coach, Long> {
    List<Coach> findAll();
    @Query(nativeQuery = true, value= "select coach0_.id, coach0_.username, coach0_.firstname, coach0_.lastname , coach0_.address, coach0_.phonenumber from coach coach0_")
    List<Object[]> findAllCoachsOnly();
    
    Coach findById(Integer id);
}