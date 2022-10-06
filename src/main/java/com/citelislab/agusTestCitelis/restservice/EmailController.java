package com.citelislab.agusTestCitelis.restservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmailController {
  @Autowired private EmailService emailService;
 
  @PostMapping("/sendProcessMail")
  public String
  sendPMail(@RequestBody EmailDetails details)
  {
    String status
      = emailService.sendProcessMail(details);

    return status;
  }

  @PostMapping("/sendProcessAllClients")
  public String sendAllClients(@RequestBody EmailDetails details) {
    String status = emailService.sendAllProccessMail(details);

    return status;
  }

  // Sending a simple Email
  @PostMapping("/sendMail")
  public String
  sendMail(@RequestBody EmailDetails details)
  {
      String status
          = emailService.sendSimpleMail(details);

      return status;
  }

  // Sending email with attachment
  @PostMapping("/sendMailWithAttachment")
  public String sendMailWithAttachment(
      @RequestBody EmailDetails details)
  {
      String status
          = emailService.sendMailWithAttachment(details);

      return status;
  }
}
