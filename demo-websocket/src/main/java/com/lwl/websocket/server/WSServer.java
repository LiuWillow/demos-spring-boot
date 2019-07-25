package com.lwl.websocket.server;

import com.lwl.websocket.config.WSConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author liuweilong
 * date 2019/7/24 13:50
 * desc
 */
@ServerEndpoint(value = "/ws/{userId}", configurator = WSConfig.class)
@Slf4j
@Component
public class WSServer {
    private static final Map<Long, List<Session>> USER_SESSION_MAP = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Long userId){
        //TODO 判断是否已经登录，如果登录了，就到cookie里拿到用户信息，放入session
        List<Session> sameUserSessions = USER_SESSION_MAP.get(userId);
        if (CollectionUtils.isEmpty(sameUserSessions)){
            sameUserSessions = new ArrayList<>();
        }

        sameUserSessions.add(session);
        USER_SESSION_MAP.put(userId, sameUserSessions);
        log.info("用户：{}已连接，当前在线人数：{}", userId, USER_SESSION_MAP.size());
    }

    @OnClose
    public void onClose(@PathParam("userId") Long userId){
        log.info("用户{}连接关闭", userId);
        USER_SESSION_MAP.remove(userId);
    }

    @OnError
    public void onError(Throwable e){
        log.error("连接异常", e);
    }

    @OnMessage
    public void onMessage(String message){
        log.info("");
    }

    public void sendMessage(Long userId, String msg){
        List<Session> sessions = USER_SESSION_MAP.get(userId);
        if (CollectionUtils.isEmpty(sessions)){
            return;
        }
        sessions.forEach(session -> session.getAsyncRemote().sendText(msg));
    }
}
