package com.group.tto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_ADMIN")
public class Admin {
  @Id
  @Column(name = "ADMIN_ID")
  @SequenceGenerator(name = "ADMIN_ID_SEQ", sequenceName = "SEQ_TTO_ADMIN_ID")
  @GeneratedValue(generator = "ADMIN_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long adminId;
  @Column(name = "LOGIN_NAME")
  private String loginname;
  @Column(name = "PASSWORD")
  private String password;

  public Long getAdminId() {
    return adminId;
  }

  public void setAdminId(Long adminId) {
    this.adminId = adminId;
  }

  public String getLoginname() {
    return loginname;
  }

  public void setLoginname(String loginname) {
    this.loginname = loginname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


}
