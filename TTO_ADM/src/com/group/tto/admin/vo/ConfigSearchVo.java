package com.group.tto.admin.vo;

import java.util.ArrayList;
import java.util.List;

import com.group.tto.cmn.model.Configuration;
import com.group.tto.cmn.type.ConfigName;

public class ConfigSearchVo {
  private String hotLine;
  private Long orderAutoConfirmTime;
  private Long orderAutoCancelTime;
  private List<CategoryVo> categorys = new ArrayList<CategoryVo>();

  public ConfigSearchVo() {}

  public ConfigSearchVo(List<Configuration> configs) {
    for (Configuration config : configs) {
      if (config.getConfigName().equals(ConfigName.AUTO_CANCEL_TIME.toString())) {
        this.orderAutoCancelTime = Long.parseLong(config.getConfigValue());
      } else if (config.getConfigName().equals(ConfigName.AUTO_CONFIRM_TIME.toString())) {
        this.orderAutoConfirmTime = Long.parseLong(config.getConfigValue());
      } else if (config.getConfigName().equals(ConfigName.SERIVCE_HOT_LINE.toString())) {
        this.hotLine = config.getConfigValue();
      } else if (config.getConfigName().equals(ConfigName.CATEGORY_NAME.toString())) {
        this.categorys.add(new CategoryVo(config.getConfigId(), config.getConfigValue()));
      }
    }
  }

  public List<Configuration> toModel() {
    List<Configuration> configs = new ArrayList<Configuration>();
    Configuration hotLineConfig = new Configuration();
    hotLineConfig.setConfigName(ConfigName.SERIVCE_HOT_LINE.toString());
    hotLineConfig.setConfigValue(hotLine);
    configs.add(hotLineConfig);

    Configuration orderAutoConfirmTimeConfig = new Configuration();
    orderAutoConfirmTimeConfig.setConfigName(ConfigName.AUTO_CONFIRM_TIME.toString());
    orderAutoConfirmTimeConfig.setConfigValue(orderAutoConfirmTime.toString());
    configs.add(orderAutoConfirmTimeConfig);

    Configuration orderAutoCancelTimeConfig = new Configuration();
    orderAutoCancelTimeConfig.setConfigName(ConfigName.AUTO_CANCEL_TIME.toString());
    orderAutoCancelTimeConfig.setConfigValue(orderAutoCancelTime.toString());
    configs.add(orderAutoCancelTimeConfig);

    for (CategoryVo vo : this.categorys) {
      Configuration temp = new Configuration();
      temp.setConfigId(vo.getConfigId());
      temp.setConfigValue(vo.getConfigValue());
      temp.setConfigName(ConfigName.CATEGORY_NAME.toString());
      configs.add(temp);
    }

    return configs;
  }

  public String getHotLine() {
    return hotLine;
  }

  public void setHotLine(String hotLine) {
    this.hotLine = hotLine;
  }

  public Long getOrderAutoConfirmTime() {
    return orderAutoConfirmTime;
  }

  public void setOrderAutoConfirmTime(Long orderAutoConfirmTime) {
    this.orderAutoConfirmTime = orderAutoConfirmTime;
  }

  public Long getOrderAutoCancelTime() {
    return orderAutoCancelTime;
  }

  public void setOrderAutoCancelTime(Long orderAutoCancelTime) {
    this.orderAutoCancelTime = orderAutoCancelTime;
  }

  public List<CategoryVo> getCategorys() {
    return categorys;
  }

  public void setCategorys(List<CategoryVo> categorys) {
    this.categorys = categorys;
  }



}
