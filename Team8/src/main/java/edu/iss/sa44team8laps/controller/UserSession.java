package edu.iss.sa44team8laps.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import edu.iss.sa44team8laps.model.Employee;
import edu.iss.sa44team8laps.model.Role;
import edu.iss.sa44team8laps.model.User;


@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {

	private String sessionId = null;
	private User user = null;
	private String type=null;
	
	public UserSession() {
		super();
	}
	public UserSession(String sessionId, User user, String type) {
		super();
		this.sessionId = sessionId;
		this.user = user;
		this.type=type;
	}
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	
}
