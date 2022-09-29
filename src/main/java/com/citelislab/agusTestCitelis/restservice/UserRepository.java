package com.citelislab.agusTestCitelis.restservice;

import org.springframework.data.repository.CrudRepository;

import com.citelislab.agusTestCitelis.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  
}
