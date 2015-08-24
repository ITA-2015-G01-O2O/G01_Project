package com.group.tto.main.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class BaseController {
  @RequestMapping("/{view}.view")
  public String view(@PathVariable String view) {
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
