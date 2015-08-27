package com.group.tto.main.common;

import org.slf4j.LoggerFactory;

public class SystemLogger {
  public static void info(LoggerNames loggerNames, String info) {
    LoggerFactory.getLogger(loggerNames.toString()).info(info);
  }

  public static void debug(LoggerNames loggerNames, String info) {
    LoggerFactory.getLogger(loggerNames.toString()).debug(info);
  }

  public static void error(LoggerNames loggerNames, String info) {
    LoggerFactory.getLogger(loggerNames.toString()).error(info);
  }
}
