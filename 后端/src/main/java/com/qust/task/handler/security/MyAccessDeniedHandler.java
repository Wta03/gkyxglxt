package com.qust.task.handler.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qust.task.util.Msg;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().mess("无访问权限").code(10007)));
    }
}
