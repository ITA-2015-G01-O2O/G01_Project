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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((configId == null) ? 0 : configId.hashCode());
    result = prime * result + ((configName == null) ? 0 : configName.hashCode());
    result = prime * result + ((configValue == null) ? 0 : configValue.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Configuration other = (Configuration) obj;
    if (configId == null) {
      if (other.configId != null) return false;
    } else if (!configId.equals(other.configId)) return false;
    if (configName == null) {
      if (other.configName != null) return false;
    } else if (!configName.equals(other.configName)) return false;
    if (configValue == null) {
      if (other.configValue != null) return false;
    } else if (!configValue.equals(other.configValue)) return false;
    return true;
  }


}
