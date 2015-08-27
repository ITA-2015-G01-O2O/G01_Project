package com.group.tto.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.main.service.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController extends BaseController {

  @Autowired
  @Qualifier("locationWebService")
  private LocationService locationService;

  @RequestMapping(value = "/loadLocation.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String getLocations(String query,Integer limit) {
    return this.getResultJSON(true, this.locationService.search(query, " ",limit));
  }

  @Override
  protected String getName() {
    return "";
  }
}
