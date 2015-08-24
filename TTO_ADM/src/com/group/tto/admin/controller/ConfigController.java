package com.group.tto.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/config")
public class ConfigController extends BaseController {

  @Override
  protected String getName() {
    return "config";
  }

}
