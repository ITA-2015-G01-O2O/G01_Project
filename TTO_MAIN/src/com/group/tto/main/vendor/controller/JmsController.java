package com.group.tto.main.vendor.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.tto.cmn.model.Account;
import com.group.tto.cmn.model.Store;
import com.group.tto.main.common.Constants;
import com.group.tto.main.common.OrderJMSMsg;
import com.group.tto.main.task.JMSAcceptor;

@Controller
@RequestMapping("/vendor/jmsController")
public class JmsController extends BaseController {

	@Override
	protected String getName() {
		return "main/vendor";
	}

	@RequestMapping(value = "/jms.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<OrderJMSMsg> jmsController(HttpServletRequest req) {
		List<OrderJMSMsg> jms = JMSAcceptor.getAllMsg();
		return jms;
	}

}
