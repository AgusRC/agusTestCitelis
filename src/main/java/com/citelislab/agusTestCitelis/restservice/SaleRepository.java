package com.citelislab.agusTestCitelis.restservice;

import org.springframework.data.repository.Repository;

import com.citelislab.agusTestCitelis.entities.Sale;
import com.citelislab.agusTestCitelis.entities.User;

public interface SaleRepository extends Repository<Sale, Integer> {
  Sale findByClientAndSeller(User client, User seller);
  Sale findByClient(User client);
}
