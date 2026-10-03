package com.reis.financeiro.security;
import javax.servlet.http.HttpServletResponse;

import com.reis.financeiro.entities.User;
import com.reis.financeiro.exceptions.GlobalExceptionHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil){
        setAuthenticationFailureHandler(new GlobalExceptionHandler());
        this.authenticationManager =authenticationManager;
        this.jwtUtil = jwtUtil;


    }
    @Override
    public Authentication attemptAuthetication(HttpServletRequest request,
                                               jakarta.servlet.http.HttpServletResponse response) throws
            AuthenticationException{
        try{
            User userCredentials = new ObjectMapper().readValue(request.getInputStream(), User.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userCredentials.getUsername(), userCredentials.getPassword(), new ArrayList<>());
            Authentication authentication = this.authenticationManager.authenticate(authToken);
            return authentication;

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void sucessfulAuthentication(HttpServletRequest request,
                                           jakarta.servlet.http.HttpServletResponse response,
                                           FilterChain filterChain, Authentication authentication) throws IOException, ServletException{
        UserSpringSecurity userSpringSecurity = (UserSpringSecurity) authentication.getPrincipal();
        String username = userSpringSecurity.getUsername();
        String token = this.jwtUtil.generateToken(username);
        response.addHeader("Authorization", "Bearer "+ token);
        response.addHeader("acess-control-expose-headers", "Authorization");
    }
}
