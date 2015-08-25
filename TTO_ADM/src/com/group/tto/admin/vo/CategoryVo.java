package com.group.tto.admin.vo;

import java.util.Map;

import com.group.tto.admin.cmn.StringUtils;

public class CategoryVo {
  private Long configId;
  private String configValue;

  public CategoryVo() {}

  public CategoryVo(Long configId, String configValue) {
    super();
    this.configId = configId;
    this.configValue = configValue;
  }

  public CategoryVo(Map<String, Object> map) {
    super();
    if (map.containsKey("configId")) {
      if(StringUtils.isNullOrEmpty(map.get("configId").toString())){
        this.configId = null;
      }else{
        this.configId = Long.parseLong(map.get("configId").toString());
      }
    } else {
      this.configId = null;
    }

    this.configValue = map.get("configValue").toString();
  }

  public Long getConfigId() {
    return configId;
  }

  public void setConfigId(Long configId) {
    this.configId = configId;
  }

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }



}
