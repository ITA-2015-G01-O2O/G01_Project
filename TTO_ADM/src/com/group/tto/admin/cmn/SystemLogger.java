package com.group.tto.admin.cmn;

import org.slf4j.LoggerFactory;

public class SystemLogger {
  public void info(LoggerNames loggerNames, String info) {
    LoggerFactory.getLogger(loggerNames.toString()).info(info);
  }

  public void debug(LoggerNames loggerNames, String info) {
    LoggerFactory.getLogger(loggerNames.toString()).debug(info);
  }

  public void error(LoggerNames loggerNames, String info) {
    LoggerFactory.getLogger(loggerNames.toString()).error(info);
  }
}
