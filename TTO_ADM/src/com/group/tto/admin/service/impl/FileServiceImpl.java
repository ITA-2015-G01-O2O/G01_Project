package com.group.tto.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.admin.service.FileService;
import com.group.tto.admin.dao.FileDao;

@Service
public class FileServiceImpl implements FileService {
  @Autowired
  private FileDao fileDao;

  @Override
  public byte[] getBy(String uuid) {
    return fileDao.getBy(uuid);
  }
}
