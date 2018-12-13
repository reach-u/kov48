package com.reach_u.kov48.rest.auth;

import com.google.common.collect.Lists;
import com.reach_u.kov48.model.Person;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.service.SessionCache;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class AuthFilter extends OncePerRequestFilter {

    private final SessionCache sessionCache;

    private static final Collection<SimpleGrantedAuthority> ROLE_USER =
            Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER"));

    public AuthFilter(SessionCache sessionCache) {
        this.sessionCache = sessionCache;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String key = request.getParameter(Constants.API_KEY);
        if (key == null) {
            key = request.getHeader(Constants.API_KEY);
        }

        if (key != null) {
            Person person = sessionCache.get(key);
            if (person != null) {
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(person, null, ROLE_USER));
            }
        }

        filterChain.doFilter(request, response);
    }
}
