package com.group.tto.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.admin.service.ConfigService;
import com.group.tto.admin.vo.CategoryVo;
import com.group.tto.admin.vo.ConfigSearchVo;
import com.group.tto.cmn.model.Configuration;

@Controller
@RequestMapping("/config")
public class ConfigController extends BaseController {

  @Autowired
  private ConfigService service;

  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public ConfigSearchVo load() {
    List<Configuration> configs = this.service.getAll();
    return new ConfigSearchVo(configs);
  }

  @RequestMapping(value = "/save.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String save(String hotLine, Long orderAutoConfirmTime, Long orderAutoCancelTime,
      String categorys) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    List<Map<String, Object>> list = mapper.readValue(categorys, List.class);

    List<CategoryVo> vos = new ArrayList<CategoryVo>();
    for (Map<String, Object> map : list) {
      vos.add(new CategoryVo(map));
    }

    ConfigSearchVo vo = new ConfigSearchVo();
    vo.setCategorys(vos);
    vo.setHotLine(hotLine);
    vo.setOrderAutoCancelTime(orderAutoCancelTime);
    vo.setOrderAutoConfirmTime(orderAutoConfirmTime);

    this.service.saveConfig(vo.toModel());
    return this.getResultJSON(true, "");
  }

  @Override
  protected String getName() {
    return "config";
  }

}
