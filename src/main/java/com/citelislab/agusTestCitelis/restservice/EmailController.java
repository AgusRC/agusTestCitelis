package com.citelislab.agusTestCitelis.restservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmailController {
  @Autowired private EmailService emailService;
 
  @PostMapping("/sendProcessMail")
  public String
  sendPMail(@RequestBody EmailDetails details) {
    try {
      String status
      = emailService.sendProcessMail(details);
      return status;
    } catch (ResponseStatusException e) {
      System.out.println(e.getMessage());
      throw new ResponseStatusException(e.getStatus(), e.getMessage());
    }
    

   
  }

  @PostMapping("/sendProcessAllClients")
  public String sendAllClients(@RequestBody EmailDetails details) {
    String status = emailService.sendAllProccessMail(details);

    return status;
  }
}
