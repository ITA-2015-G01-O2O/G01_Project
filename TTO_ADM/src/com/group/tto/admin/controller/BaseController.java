package com.group.tto.admin.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.tto.admin.cmn.LoggerNames;
import com.group.tto.admin.cmn.SystemLogger;

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
    } catch (Exception e) {
      SystemLogger.error(LoggerNames.ERROR_APPENDER, "convert json error:" + obj);
      isSuccess = false;
      data = "system.error";
    }
    return "{\"isSuccess\":" + isSuccess + ",\"data\":" + data + "}";
  }

  protected String getPageJSON(List<Object> list, Long total) {
    String data = "";
    try {
      data = new ObjectMapper().writeValueAsString(list);
    } catch (Exception e) {
      SystemLogger.error(LoggerNames.ERROR_APPENDER, "convert json error:" + list);
      data = "[]";
      total = 0L;
    }
    return "{\"total\":" + total + ",\"datas\":" + data + "}";
  }
}
