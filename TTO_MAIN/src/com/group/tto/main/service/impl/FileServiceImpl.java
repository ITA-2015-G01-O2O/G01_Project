package com.group.tto.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.tto.main.dao.FileDao;
import com.group.tto.main.service.FileService;

@Service
public class FileServiceImpl implements FileService {

  @Autowired
  private FileDao fileDao;

  @Override
  public byte[] getBy(String uuid) {
    return fileDao.getBy(uuid);
  }

  public FileDao getFileDao() {
    return fileDao;
  }

  public void setFileDao(FileDao fileDao) {
    this.fileDao = fileDao;
  }

}
