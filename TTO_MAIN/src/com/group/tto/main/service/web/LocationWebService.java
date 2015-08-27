package com.group.tto.main.service.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.tto.cmn.model.Location;
import com.group.tto.main.common.LoggerNames;
import com.group.tto.main.common.SystemLogger;
import com.group.tto.main.common.WebServiceHelper;
import com.group.tto.main.service.LocationService;

@Service("locationWebService")
public class LocationWebService implements LocationService {

  @Override
  public List<Location> search(String search, String splitor, Integer limit) {
    List<String> others = new ArrayList<String>();
    others.add(search);
    others.add(limit.toString());
    others.add(splitor);
    String result = WebServiceHelper.getWebServiceResult(Location.class, others);
    return this.convert(result);
  }

  @Override
  public List<Location> search(String area, String city, String place, Integer limit) {
    List<String> others = new ArrayList<String>();
    others.add(area + "%20" + city + "%20" + "%20" + place);
    others.add(limit.toString());
    others.add("%20");
    String result = WebServiceHelper.getWebServiceResult(Location.class, others);
    return this.convert(result);
  }

  private List<Location> convert(String result) {
    List<Location> locations = new ArrayList<Location>();
    try {
      List<Map> list = new ObjectMapper().readValue(result, List.class);
      for (Map ele : list) {
        Location location = new Location();
        location.setArea(ele.get("area").toString());
        location.setPlace(ele.get("place").toString());
        location.setCity(ele.get("city").toString());
        location.setLocationId(Long.parseLong(ele.get("locationId").toString()));
        locations.add(location);
      }
    } catch (Exception e) {
      SystemLogger.error(LoggerNames.ERROR_APPENDER, e.getMessage());
    }
    return locations;
  }

}
