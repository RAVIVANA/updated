package com.nkxgen.spring.jdbc.listeners;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.nkxgen.spring.jdbc.Dao.AuditLogDAO;
import com.nkxgen.spring.jdbc.events.LoginEvent;
import com.nkxgen.spring.jdbc.model.AuditLogs;

@Component
public class LoginListener 
{
	@Autowired
	AuditLogDAO auditLogDAO;

	@EventListener
	public void login(LoginEvent event)
	{
		auditLogDAO.saveAudit(new AuditLogs("Logged In",new Timestamp(System.currentTimeMillis()),"No User"));
		System.out.println("Login Event Fired");
	}
}
