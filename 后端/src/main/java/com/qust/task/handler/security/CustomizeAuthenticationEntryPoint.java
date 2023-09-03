package com.qust.task.handler.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qust.task.util.Msg;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().mess("未登录或登录失效").code(10006)));
    }
}
