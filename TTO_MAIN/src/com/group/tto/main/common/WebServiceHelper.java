package com.group.tto.main.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.group.tto.cmn.model.Location;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class WebServiceHelper {
  private static Map<Class, String> urlMapper = Collections
      .synchronizedMap(new HashMap<Class, String>());
  private static String baseUrl = "";

  static {
    try {
      Properties properties = new Properties();
      properties.load(JMSHelper.class.getResourceAsStream("/webService.properties"));
      baseUrl = properties.getProperty("baseUrl");
      for (Object key : properties.keySet()) {
        if (!key.toString().equals("baseUrl")) {
          urlMapper.put(Class.forName(key.toString()), properties.getProperty(key.toString()));
        }
      }
    } catch (Exception e) {
      SystemLogger.error(LoggerNames.ERROR_APPENDER, "Web Service Helper load properties failed");
    }
  }

  public static String getWebServiceResult(Class clazz, List<String> others) {
    Client client = Client.create();
    String url = baseUrl + urlMapper.get(clazz);
    String temp = "";
    for (String other : others) {
      try {
        temp += "/" + URLEncoder.encode(new String(other.getBytes(), "UTF-8"), "UTF-8");
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }

    url = url + temp;

    WebResource webResource = client.resource(url);
    return webResource.get(String.class);
  }

}
