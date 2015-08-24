package com.group.tto.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_CONFIG")
public class Configuration {
  @Id
  @Column(name = "CONFIG_ID")
  @SequenceGenerator(name = "CONFIG_ID_SEQ", sequenceName = "SEQ_TTO_CONFIG_ID")
  @GeneratedValue(generator = "CONFIG_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long configId;
  @Column(name = "CONFIG_NAME")
  private String configName;
  @Column(name = "CONFIG_VAL")
  private String configValue;

  public Long getConfigId() {
    return configId;
  }

  public void setConfigId(Long configId) {
    this.configId = configId;
  }

  public String getConfigName() {
    return configName;
  }

  public void setConfigName(String configName) {
    this.configName = configName;
  }

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }


}
