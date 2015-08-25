package com.group.tto.main.dao;

import java.io.InputStream;

public interface FileDao {
  public void saveFile(InputStream input, String uuid);

  public byte[] getBy(String uuid);
}
