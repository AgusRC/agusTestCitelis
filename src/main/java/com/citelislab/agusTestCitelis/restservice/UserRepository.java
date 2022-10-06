package com.citelislab.agusTestCitelis.restservice;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.citelislab.agusTestCitelis.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByEmail(String email);
  Optional<User> findById(Integer id);
}
