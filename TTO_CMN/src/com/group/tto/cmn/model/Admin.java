package com.group.tto.cmn.model;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
    result = prime * result + ((loginname == null) ? 0 : loginname.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Admin other = (Admin) obj;
    if (adminId == null) {
      if (other.adminId != null) return false;
    } else if (!adminId.equals(other.adminId)) return false;
    if (loginname == null) {
      if (other.loginname != null) return false;
    } else if (!loginname.equals(other.loginname)) return false;
    if (password == null) {
      if (other.password != null) return false;
    } else if (!password.equals(other.password)) return false;
    return true;
  }


}
