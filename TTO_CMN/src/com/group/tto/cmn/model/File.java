package com.group.tto.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_FILE")
public class File {
  @Id
  @Column(name = "FILE_ID")
  @SequenceGenerator(name = "FILE_ID_SEQ", sequenceName = "SEQ_TTO_FILE_ID")
  @GeneratedValue(generator = "FILE_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long fileId;
  @Column(name = "UUID")
  private String uuid;
  @Lob
  @Column(name = "FILE_CONTEXT")
  private byte[] fileContext;

  public Long getFileId() {
    return fileId;
  }

  public void setFileId(Long fileId) {
    this.fileId = fileId;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public byte[] getFileContext() {
    return fileContext;
  }

  public void setFileContext(byte[] fileContext) {
    this.fileContext = fileContext;
  }



}
