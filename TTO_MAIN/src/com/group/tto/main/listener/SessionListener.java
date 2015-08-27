package com.group.tto.main.listener;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.group.tto.cmn.model.Account;
import com.group.tto.main.common.Constants;

public class SessionListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent arg0) {
    // TODO Auto-generated method stub
  }

  public void sessionDestroyed(HttpSessionEvent arg0) {
    HttpSession session = arg0.getSession();
    Account account = (Account) session.getAttribute(Constants.SESSION_LOGIN_INFO);
    Long id = account.getAccountId();
    List<Account> accounts =
        (List<Account>) session.getServletContext().getAttribute(Constants.CONTEXT_LOGIN_INFO);
    if (accounts != null) {
      for (int i = accounts.size() - 1; i >= 0; i--) {
        if (accounts.get(i).getAccountId().equals(id)) {
          accounts.remove(i);
          break;
        }
      }
    }
  }

}
