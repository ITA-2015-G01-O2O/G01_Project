package com.group.tto.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.admin.cmn.ShopSearchCriteria;
import com.group.tto.admin.dto.PageDTO;
import com.group.tto.admin.service.LocationService;
import com.group.tto.admin.service.ShopService;
import com.group.tto.admin.vo.ShopSearchVo;
import com.group.tto.admin.vo.ShopViewVo;
import com.group.tto.admin.vo.UserSearchVo;
import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Location;
import com.group.tto.cmn.model.Store;

@Controller
@RequestMapping("/shop")
public class ShopController extends BaseController {

  @Autowired
  private ShopService service;
  @Autowired
  private LocationService locationService;

  @RequestMapping(value = "/load.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public PageDTO<ShopSearchVo> load(ShopSearchCriteria searchCriteria) {
    return this.converToSearchVo(this.service.search(searchCriteria));
  }

  @RequestMapping(value = "/setHot.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String setHot(Long id) {
    this.service.setHot(id);
    return this.getResultJSON(true, "");
  }

  @RequestMapping(value = "/setNoHot.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String setNoHot(Long id) {
    this.service.setNoHot(id);
    return this.getResultJSON(true, "");
  }

  @RequestMapping(value = "/active.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String active(Long id) {
    this.service.activeStore(id);
    return this.getResultJSON(true, "");
  }

  @RequestMapping(value = "/inactive.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String inactive(Long id) {
    this.service.inactiveStore(id);
    return this.getResultJSON(true, "");
  }

  @RequestMapping(value = "/loadLocation.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public String getLocations(String query) {
    return this.getResultJSON(true, this.locationService.search(query," "));
  }

  @RequestMapping(value = "/getDetail.do", produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public ShopViewVo getDetail(Long id) {
    return new ShopViewVo(this.service.get(id), "/TTO_Admin/file/img/");
  }

  @RequestMapping(value = "/detail.view", produces = {"application/json;charset=UTF-8"})
  public String detailView(Long id, Map<String, String> map) {
    map.put("id", id.toString());
    return "shop/shopView";
  }

  @Override
  protected String getName() {
    return "shop";
  }

  private PageDTO<ShopSearchVo> converToSearchVo(PageDTO<Store> data) {
    PageDTO<ShopSearchVo> page = new PageDTO<ShopSearchVo>();
    List<ShopSearchVo> vos = new ArrayList<ShopSearchVo>();
    for (Store store : data.getDatas()) {
      vos.add(new ShopSearchVo(store));
    }
    page.setLimit(data.getLimit());
    page.setStart(data.getStart());
    page.setTotal(data.getTotal());
    page.setDatas(vos);
    return page;
  }

}
