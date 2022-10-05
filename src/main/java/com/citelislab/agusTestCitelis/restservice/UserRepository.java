package com.citelislab.agusTestCitelis.restservice;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.citelislab.agusTestCitelis.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByEmail(String email);
}
