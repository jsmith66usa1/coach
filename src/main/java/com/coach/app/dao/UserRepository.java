package com.coach.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coach.app.model.User;




// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    
    @Query(nativeQuery = true, value= "select  user0_.id, user0_.firstname , user0_.lastname , user0_.address, user0_.phonenumber from user user0_")
    List<Object[]> findAllUsersOnly();
}