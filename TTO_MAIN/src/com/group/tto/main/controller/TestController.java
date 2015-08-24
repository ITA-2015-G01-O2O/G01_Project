package com.group.tto.main.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TestController extends BaseController {

  @Override
  protected String getName() {
    return "test";
  }

}
