package com.citelislab.agusTestCitelis.restservice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.citelislab.agusTestCitelis.entities.Sale;
import com.citelislab.agusTestCitelis.entities.User;

public interface SaleRepository extends Repository<Sale, Integer> {
  Sale findByClientAndSeller(User client, User seller);
  Sale findByClient(User client);

  @Query(value = "SELECT sale.client_id  FROM process INNER JOIN sale ON process.id = sale.process_id WHERE process.id = ?1", nativeQuery = true)
  List<Integer> findUsersOfProcess(int processId);
}
