package com.qust.task.handler.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qust.task.model.AccountInfoModel;
import com.qust.task.model.AccountModel;
import com.qust.task.util.JwtUtils;
import com.qust.task.util.Msg;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        AccountModel model = (AccountModel) authentication.getPrincipal();
        String jwtToken = JwtUtils.getJwtToken(model.getId(), model.getUname(), model.getUtype());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountInfoModel info = new AccountInfoModel();
        info.setRealname(model.getUrealName());
        info.setUtype(model.getUtype());
        info.setUtype(info.getUtype().substring("ROLE_".length()));
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.success().mess("登陆成功").data("token", jwtToken).data("userInfo", info)));
    }
}
