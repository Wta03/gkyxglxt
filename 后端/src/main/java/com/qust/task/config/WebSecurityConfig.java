package com.qust.task.config;

import com.qust.task.filter.JwtFilter;
import com.qust.task.handler.security.CustomizeAuthenticationEntryPoint;
import com.qust.task.handler.security.MyAccessDeniedHandler;
import com.qust.task.handler.security.MyAuthenticationFailHandler;
import com.qust.task.handler.security.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.WebSphereDataSourceAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtFilter jwtFilter;
    @Autowired
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    MyAccessDeniedHandler accessDeniedHandler;
    @Autowired
    MyAuthenticationFailHandler authenticationFailHandler;
    @Autowired
    MyAuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.formLogin()
                .loginProcessingUrl("/api/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .and().authorizeRequests()
                .antMatchers("/api/login", "/login", "/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**", "api/login", "//api/login", "/image/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .configurationSource(configurationSource())
                .and()
                .csrf().disable();
    }

    private CorsConfigurationSource configurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.setAllowCredentials(true);
        //前后端分离项目需要携带cookie时，需要此句，但加上之后origin里就不能为"*"
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}
