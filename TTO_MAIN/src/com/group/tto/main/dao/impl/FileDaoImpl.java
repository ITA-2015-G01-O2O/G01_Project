package com.group.tto.main.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.group.tto.cmn.model.File;
import com.group.tto.main.dao.BaseDao;
import com.group.tto.main.dao.FileDao;

@Repository
public class FileDaoImpl extends BaseDao<File> implements FileDao {

  private static final String FIELD_UUID = "uuid";

  @Override
  public void saveFile(InputStream input, String uuid) {
    try {
      File file = new File();
      byte[] temp = new byte[input.available()];
      input.read(temp);
      file.setUuid(uuid);
      file.setFileContext(temp);
      this.getEntityManager().persist(file);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public byte[] getBy(String uuid) {
    CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<File> query = builder.createQuery(File.class);
    Root<File> file = query.from(File.class);

    Predicate predicate = builder.equal(file.get(FIELD_UUID), uuid);
    List<File> result = this.getEntityManager().createQuery(query.where(predicate)).getResultList();
    if (result.size() != 0) {
      return result.get(0).getFileContext();
    } else {
      return new byte[1];
    }
  }
}
