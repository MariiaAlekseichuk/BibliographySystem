package com.github.MaryHrisanfova.BibliographySystem.controllers;

import com.github.MaryHrisanfova.BibliographySystem.utilities.Methods;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.Base64;

/**
 * @author Mariia_Khrisanfova
 */
@Controller
@RequestMapping(Paths.LOGIN)
public class LoginController {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String BASIC = "Basic";
    private static final String ENCODING_UTF_8 = "UTF-8";
    private static final String COLON = ":";
    private static final int LIMIT_OF_PARTS = 2;
    private static final int INDEX_OF_PASSWORD = 1;
    private static final int INDEX_OF_NAME = 0;

    @Autowired
    InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @RequestMapping(Methods.LAYOUT)
    public String getLoginLayoutPage(ModelMap modelMap) {
        return (Paths.LOGIN + Methods.LAYOUT);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findUser(HttpServletRequest request, Authentication authentication, Principal principal) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        final String authorization = request.getHeader(HEADER_AUTHORIZATION);

        if (authorization != null && authorization.startsWith(BASIC)) {
            try {
                UserDetails user = inMemoryUserDetailsManager.loadUserByUsername(principal.getName());
                if (user.getPassword().equals(getPasswordFromCredentials(authorization))) {
                    httpStatus = HttpStatus.OK;
                }
            } catch (UsernameNotFoundException e) {
                //log message
            }
        }
        return new ResponseEntity<>(httpStatus);
    }

    private String getPasswordFromCredentials(String authorization) {
        String[] values;
        String base64Credentials = authorization.substring(BASIC.length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName(ENCODING_UTF_8));
        values = credentials.split(COLON, LIMIT_OF_PARTS);
        return values[INDEX_OF_PASSWORD];
    }
}
