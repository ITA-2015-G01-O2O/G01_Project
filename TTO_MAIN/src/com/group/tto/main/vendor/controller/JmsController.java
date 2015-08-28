package com.group.tto.main.vendor.controller;

import java.util.ArrayList;
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
	public List<OrderJMSMsg> jmsController(HttpServletRequest req) throws InterruptedException {
		Thread.sleep(500);
		long sid=(long) req.getSession().getAttribute("sid");
		List<OrderJMSMsg>  jms=new ArrayList<OrderJMSMsg>();
	   for(OrderJMSMsg omsg :  JMSAcceptor.getAllMsg())
	   {
		   if(omsg.getStoreId()==sid)
		   {
			   jms.add(omsg);
			   System.out.println("jms running:>>>>>>>>>>>"+jms.size());
			   req.setAttribute("jmsSize",jms.size());
		   }
	   }
		return jms;
	}
		
	@RequestMapping(value = "/removejms.do", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<OrderJMSMsg> removeJms(HttpServletRequest req) {
		String orderId=req.getParameter("id");
		System.out.println("===================================== jms remove"+orderId);
		JMSAcceptor.removeMsg(Long.parseLong(orderId));
		List<OrderJMSMsg> jms = JMSAcceptor.getAllMsg();
		return jms;
	}

}
