package com.citelislab.agusTestCitelis.restservice;

import org.springframework.stereotype.Service;

import com.citelislab.agusTestCitelis.entities.Sale;
import com.citelislab.agusTestCitelis.entities.User;

import java.io.File;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailServiceImpl implements EmailService {
  @Autowired private JavaMailSender javaMailSender;
  @Autowired private UserRepository userRepository;
  @Autowired private ProcessRepository processRepository;
  @Autowired private SaleRepository saleRepository;
  @Value("${spring.mail.username}") private String sender;

  public String sendProcessMail(EmailDetails details) {
    try {
      // search user
      User users = userRepository.findByEmail(details.getRecipient());
      System.out.println("Users found with email" + details.getRecipient() + ": " + users.getName());
      // search process
      // debi poner otro nombre a esa entidad jaja
      com.citelislab.agusTestCitelis.entities.Process process = processRepository.findById(details.getProcessId());
      // search sale register
      Sale sale = saleRepository.findByClient(users);

      // Build message
      String message = 
        "Que tal: " + users.getName() +
        " Hemos recibido su cotización de " + sale.getAutoName() + 
        ", con " + sale.getBankName() + ", con plazo de " +
        " " + sale.getTerm() + ", con un enganche de $" + sale.getHitch();

      System.out.print(message);

      // Creating a simple mail message
      SimpleMailMessage mailMessage
          = new SimpleMailMessage();

      // Setting up necessary details
      mailMessage.setFrom(sender);
      mailMessage.setTo(details.getRecipient());
      mailMessage.setText(details.getMsgBody());
      mailMessage.setSubject(details.getSubject());

      // Sending the mail
      javaMailSender.send(mailMessage);
      return "Mail Sent Successfully...";
    }
 
    catch (Exception e) {
      return "Error while Sending Mail: " + e;
    }
  }

  public String sendSimpleMail(EmailDetails details) {
    try {
      // Creating a simple mail message
      SimpleMailMessage mailMessage
          = new SimpleMailMessage();

      // Setting up necessary details
      mailMessage.setFrom(sender);
      mailMessage.setTo(details.getRecipient());
      mailMessage.setText(details.getMsgBody());
      mailMessage.setSubject(details.getSubject());

      // Sending the mail
      javaMailSender.send(mailMessage);
      return "Mail Sent Successfully...";
    }
 
    catch (Exception e) {
      return "Error while Sending Mail: " + e;
    }
  }
 
  public String
  sendMailWithAttachment(EmailDetails details) {
    // Creating a mime message
    MimeMessage mimeMessage
        = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;

    try {
      // Setting multipart as true for attachments to
      // be send
      mimeMessageHelper
          = new MimeMessageHelper(mimeMessage, true);
      mimeMessageHelper.setFrom(sender);
      mimeMessageHelper.setTo(details.getRecipient());
      mimeMessageHelper.setText(details.getMsgBody());
      mimeMessageHelper.setSubject(
          details.getSubject());

      // Adding the attachment
      FileSystemResource file
          = new FileSystemResource(
              new File(details.getAttachment()));

      mimeMessageHelper.addAttachment(
          file.getFilename(), file);

      // Sending the mail
      javaMailSender.send(mimeMessage);
      return "Mail sent Successfully";
    }

    catch (MessagingException e) {
      System.out.print(e);
      return "Error while sending mail: " + e;
    }
  }
}
