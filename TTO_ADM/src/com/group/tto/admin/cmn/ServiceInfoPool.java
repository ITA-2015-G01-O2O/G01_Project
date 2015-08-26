package com.group.tto.admin.cmn;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServiceInfoPool {

  private static Map<String, Object> store = Collections
      .synchronizedMap(new HashMap<String, Object>());

  private ServiceInfoPool() {}

  public static void addAttribute(String name, String value) {
    store.put(name, value);
  }

  public static Object getAttribute(String name) {
    return store.get(name);
  }

}
