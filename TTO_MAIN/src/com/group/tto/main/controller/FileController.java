package com.group.tto.main.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.tto.main.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {

  @Autowired
  private FileService service;

  @RequestMapping("/img/{uuid}")
  public void loadImg(@PathVariable String uuid, HttpServletResponse response) {
    response.setContentType("image/*; charset=utf-8");
    try {
      response.getOutputStream().write(this.service.getBy(uuid));
      response.getOutputStream().flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
}
