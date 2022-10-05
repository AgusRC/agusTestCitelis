package com.citelislab.agusTestCitelis.entities;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Sale {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private String autoName;

  private String bankName;

  private String term; // plazo
  
  private String hitch; // enganche
  
  // RELACIONES

  @ManyToOne
  @JoinColumn(name = "seller_id", foreignKey = @ForeignKey(name = "SELLER_ID_FK"))
  private User seller;

  @ManyToOne
  @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "CLIENT_ID_FK"))
  private User client;

  @ManyToOne
  @JoinColumn(name = "process_id", foreignKey = @ForeignKey(name = "PROCESS_ID_FK"))
  private Process process;
  
  // GETTERS SETTERS

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public User getSeller() {
    return seller;
  }

  public void setSeller(User seller) {
    this.seller = seller;
  }

  public String getHitch() {
    return hitch;
  }

  public void setHitch(String hitch) {
    this.hitch = hitch;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAutoName() {
    return autoName;
  }

  public void setAutoName(String autoName) {
    this.autoName = autoName;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

}