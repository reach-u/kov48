package com.reach_u.kov48.rest.auth;

import com.google.common.collect.Lists;
import com.reach_u.kov48.model.User;
import com.reach_u.kov48.rest.Constants;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String key = request.getParameter(Constants.API_KEY);
        if (key == null) {
            key = request.getHeader(Constants.API_KEY);
        }

        if (key != null) {
            Authentication auth = new UsernamePasswordAuthenticationToken(new User(key), null,
                    Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }


        filterChain.doFilter(request, response);
    }
}
