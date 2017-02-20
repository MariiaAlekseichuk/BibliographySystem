package com.github.MaryHrisanfova.BibliographySystem.controllers;

import com.github.MaryHrisanfova.BibliographySystem.utilities.Paths;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mariia_Khrisanfova
 */

@Controller
@RequestMapping(Paths.LOGOUT)
public class LogoutController {
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    boolean logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userName");
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityContextLogoutHandler contextLogoutHandler = new SecurityContextLogoutHandler();
        contextLogoutHandler.logout(request, response, authentication);
        return true;
    }
}
