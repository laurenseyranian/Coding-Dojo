package com.codingdojo.tasks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tasks.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
// ----------------------------------------------------------------------------------------------
// FINDS a user by EMAIL
// ----------------------------------------------------------------------------------------------  
	User findByEmail(String email);
// ----------------------------------------------------------------------------------------------
// FINDS all users
// ----------------------------------------------------------------------------------------------
    List<User> findAll();
}