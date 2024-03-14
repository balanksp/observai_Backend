package com.zaga.kafka.websocket;

import java.util.HashSet;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint(value = "/websocket", encoders = { CustomEncoder.class })
public class WebsocketAlertProducer {

    private Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void addSession(Session session) {
        System.out.println("addSession");
        sessions.add(session);
    }

    @OnClose
    public void removeSession(Session session) {
        System.out.println("removeSession");
        sessions.remove(session);
    }

    public Set<Session> getSessions() {
        return sessions;
    }

}
