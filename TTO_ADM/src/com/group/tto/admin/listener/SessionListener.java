package com.group.tto.admin.listener;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.group.tto.admin.cmn.TTOConstants;
import com.group.tto.cmn.model.Admin;

public class SessionListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent arg0) {
    // TODO Auto-generated method stub
  }

  public void sessionDestroyed(HttpSessionEvent arg0) {
    HttpSession session = arg0.getSession();
    Admin admin = (Admin) session.getAttribute(TTOConstants.SESSION_LOGIN_INFO);
    Long id = admin.getAdminId();
    List<Admin> admins =
        (List<Admin>) session.getServletContext().getAttribute(TTOConstants.CONTEXT_LOGIN_INFO);
    if (admins != null) {
      for (int i = admins.size() - 1; i >= 0; i--) {
        if (admins.get(i).getAdminId().equals(id)) {
          admins.remove(i);
          break;
        }
      }
    }
  }

}
