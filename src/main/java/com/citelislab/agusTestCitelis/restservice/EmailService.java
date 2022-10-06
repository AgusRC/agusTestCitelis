package com.citelislab.agusTestCitelis.restservice;

public interface EmailService {
  String sendProcessMail(EmailDetails details);

  String sendAllProccessMail(EmailDetails details);
}
