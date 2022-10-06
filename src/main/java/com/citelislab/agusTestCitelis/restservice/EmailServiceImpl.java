package com.citelislab.agusTestCitelis.restservice;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.citelislab.agusTestCitelis.entities.Sale;
import com.citelislab.agusTestCitelis.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
  @Autowired private UserRepository userRepository;
  @Autowired private ProcessRepository processRepository;
  @Autowired private SaleRepository saleRepository;
  @Value("${spring.mail.username}") private String sender;

  public String sendProcessMail(EmailDetails details) {
    try {
      // search user
      User user = userRepository.findByEmail(details.getRecipient());
      if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro un usuario con este email");
      
      // search sale register
      Sale sale = saleRepository.findByClient(user);
      if (sale == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este usuario no tiene una venta activa");

      // Build message
      String res = buildAndSendMail(
        user.getName(),
        sale.getAutoName(),
        sale.getBankName(),
        sale.getTerm(),
        sale.getHitch(),
        user.getEmail(),
        details
      );

      return res;
    } catch (ResponseStatusException e) {
      throw new ResponseStatusException(e.getStatus(), e.getMessage());
    }
  }

  public String sendAllProccessMail(EmailDetails details) {
    try {
      // search process
      // debi poner otro nombre a esa entidad jaja, no recordaba que "Process" es reservado de java
      com.citelislab.agusTestCitelis.entities.Process process = processRepository.findById(details.getProcessId());
      if (process == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro un proceso con este id");
      // search sale register
      List<Integer> usersIds = saleRepository.findUsersOfProcess(process.getId());
      for (Integer userId : usersIds) {

        // buscar email y mandar email a cada uno
        Optional<User> userToSend = userRepository.findById(userId);

        // buscar datos de ventas
        Sale sale = saleRepository.findByClient(userToSend.get());

        // Build message
        buildAndSendMail(
          userToSend.get().getName(),
          sale.getAutoName(),
          sale.getBankName(),
          sale.getTerm(),
          sale.getHitch(),
          userToSend.get().getEmail(),
          details
        );
      }

      return "Mail Sent Successfully...";
    } catch (ResponseStatusException e) {
      throw e;
    }
  }

  private String buildAndSendMail(String clientName, String autoName, String bank_name, String term, String hitch, String mail, EmailDetails details) {
    try {
      // No supe si los placeholders son solo estos o se necesitarian definir, para asi mismo agregar validaciones
      String messageBody = details.getMsgBody();
      messageBody = messageBody.replace("%nombre_cliente%", clientName);
      messageBody = messageBody.replace("%auto%", autoName);
      messageBody = messageBody.replace("%nombre_banco%", bank_name);
      messageBody = messageBody.replace("%plazo%", term);
      messageBody = messageBody.replace("%enganche%", hitch);
      System.out.println(messageBody);

      // Creacion del mensaje
      SimpleMailMessage mailMessage
          = new SimpleMailMessage();

      
      mailMessage.setFrom(sender);
      mailMessage.setTo(mail);
      mailMessage.setText(messageBody);
      mailMessage.setSubject(details.getSubject());
      // javaMailSender.send(mailMessage);
      return "Mail Sent succefully";
    } catch (Exception e) {
      return "error to sent: " + e;
    }
  }
}
