package com.citelislab.agusTestCitelis.restservice;

import org.springframework.data.repository.CrudRepository;

import com.citelislab.agusTestCitelis.entities.Process;


public interface ProcessRepository extends CrudRepository<Process, Integer>{
  Process findById(int id);
}
