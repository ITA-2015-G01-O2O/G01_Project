package com.group.tto.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.group.tto.cmn.model.Account;
import com.group.tto.main.common.Constants;


public class VendorLoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO) == null) {
      response.sendRedirect(request.getContextPath() + "/consumer/search.view");
      return false;
    } else {
      Account account = (Account) request.getSession().getAttribute(Constants.SESSION_LOGIN_INFO);
      if (account.getStore() == null) {
        response.sendRedirect(request.getContextPath() + "/consumer/search.view");
        return false;
      } else {
        return true;
      }
    }

  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {

  }
}
