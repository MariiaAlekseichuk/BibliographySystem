package com.github.MaryHrisanfova.BibliographySystem.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mariia_Khrisanfova
 */
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    private static final String SPRING_SECURITY_REALM_NAME = "RealmName";
    private static final String APPLICATION_JSON = "application/json";

    public CustomBasicAuthenticationEntryPoint(String realmName) {
        setRealmName(realmName);
    }

    public CustomBasicAuthenticationEntryPoint() {
    }

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authenticationException) throws IOException, ServletException {
        if (authenticationException instanceof BadCredentialsException) {
            response.setContentType(APPLICATION_JSON);
            new ObjectMapper().writeValue(response.getWriter(), new AuthenticationResponse());
            return;
        }

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(SPRING_SECURITY_REALM_NAME);
        super.afterPropertiesSet();
    }


}