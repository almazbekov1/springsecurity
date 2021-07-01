package com.company.springSecurity.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        System.out.println(roles);
        if (roles.contains("ROLE_ADMIN")) {
            System.out.println("admin");
            httpServletResponse.sendRedirect("/api/admin");
        } else if(roles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/api/user");
        }else{
            httpServletResponse.sendRedirect("/login");
        }
//        httpServletResponse.sendRedirect("/");
    }
}
