package com.citelislab.agusTestCitelis.restservice;

/*
// Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
*/

public class EmailDetails {
  // Class data members
  private String recipient;
  private String msgBody;
  private String subject;
  private String attachment;

  public String getAttachment() {
    return attachment;
  }
  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }

  public String getMsgBody() {
    return msgBody;
  }
  public void setMsgBody(String msgBody) {
    this.msgBody = msgBody;
  }

  public String getRecipient() {
    return recipient;
  }
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
}
