package com.citelislab.agusTestCitelis.restservice;

public interface EmailService {
  String sendProcessMail(EmailDetails details);

  // Method
  // To send a simple email
  String sendSimpleMail(EmailDetails details);

  // Method
  // To send an email with attachment
  String sendMailWithAttachment(EmailDetails details);
}
