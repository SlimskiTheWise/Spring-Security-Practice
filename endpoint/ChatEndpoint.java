package com.spring.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;
import com.spring.config.WsConfig;

@ServerEndpoint(value="/chat", configurator = WsConfig.class)
public class ChatEndpoint {

	
	@Autowired
	private HttpSession session;
	
	private static List<Session> clients = Collections.synchronizedList(new ArrayList<>());
	
	@OnOpen
	public void onConnect(Session session, EndpointConfig config) {
		clients.add(session);
		
		this.session = (HttpSession)config.getUserProperties().get("hSession");
	}
	
	@OnMessage
	public void onMessage(String message) {
		
		
		
		String userID = (String)this.session.getAttribute("loginID");
		
		JsonObject obj = new JsonObject();
		obj.addProperty("id", userID);
		obj.addProperty("message", message);
		
	synchronized(clients) {
		for(Session client : clients) {
			try {
				client.getBasicRemote().sendText(obj.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
		System.out.println("connection has been closed");
	}
}
