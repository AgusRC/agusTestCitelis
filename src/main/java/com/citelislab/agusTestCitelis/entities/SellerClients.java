package com.citelislab.agusTestCitelis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;


@Entity
public class SellerClients {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @ManyToOne
  @JoinColumn(name = "seller_id", foreignKey = @ForeignKey(name = "USER_SELLER_ID_FK"))
  private User seller;
  
  @ManyToOne
  @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "USER_CLIENT_ID_FK"))
  private User client;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getSeller() {
    return seller;
  }

  public void setSeller(User seller) {
    this.seller = seller;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }
}
