package com.reis.financeiro.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.ServerException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
  //  private TokenService tokenService;

    @Override
    protected  void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                     FilterChain filterChain) throws ServerException, IOException{
        String path = request.getRequestURI();
        if(path.equals("/auth/gerarToke")
            || path.startsWith("/swagger-ui")
            || path.startsWith("v2/api-docs")
            || path.startsWith("v3/api-docs")
            || path.startsWith("/swagger-resources")
            || path.startsWith("/web-jars"))
        {
          //  filterChain.doFilter(request, response);
            return;
        }
    }
}
