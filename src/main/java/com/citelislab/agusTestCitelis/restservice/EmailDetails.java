package com.citelislab.agusTestCitelis.restservice;


public class EmailDetails {
  private String recipient;
  private String msgBody;
  private String subject;
  private String attachment;
  private int processId;

  public int getProcessId() {
    return processId;
  }
  public void setProcessId(int processId) {
    this.processId = processId;
  }
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
