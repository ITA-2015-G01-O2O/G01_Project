package com.group.tto.admin.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.group.tto.admin.cmn.LoggerNames;
import com.group.tto.admin.cmn.SystemLogger;
import com.group.tto.admin.service.LocationService;
import com.group.tto.cmn.model.Location;
import com.sun.jersey.spi.resource.Singleton;

@Path("/locationService")
@Component
@Scope("request")
@Singleton
public class LocationWebService {

  @Autowired
  @Qualifier("locationServiceImpl")
  private LocationService service;

  @GET
  @Scope("request")
  @Path("/location/{query}/{limit}/{splitor}")
  @Produces("application/json;charset=UTF-8")
  public String helloWorld(@PathParam("query") String query, @PathParam("limit") Integer limit,
      @PathParam("splitor") String splitor) {
    List<Location> models = this.service.search(query, splitor, limit);

    try {
      return new ObjectMapper().writeValueAsString(models);
    } catch (Exception e) {
      SystemLogger.error(LoggerNames.ERROR_APPENDER, e.getMessage());
      return "[]";
    }
  }
}
