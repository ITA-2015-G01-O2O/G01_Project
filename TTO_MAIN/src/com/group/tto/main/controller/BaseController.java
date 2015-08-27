package com.group.tto.main.controller;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.tto.main.common.Constants;
import com.group.tto.main.service.ConfigService;

public abstract class BaseController {

  @Autowired
  private ConfigService service;

  @RequestMapping("/{view}.view")
  public String view(@PathVariable String view, Map<String, String> map) {
    map.put(Constants.HOT_LINE, this.service.getHotLine());
    return this.getName() + "/" + view;
  }

  protected abstract String getName();

  protected String getResultJSON(boolean isSuccess, String data) {
    return "{\"isSuccess\":" + isSuccess + ",\"data\":\"" + data + "\"}";
  }

  protected String getResultJSON(boolean isSuccess, Object obj) {
    String data = "";
    try {
      data = new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {}
    return "{\"isSuccess\":" + isSuccess + ",\"data\":" + data + "}";
  }
}
