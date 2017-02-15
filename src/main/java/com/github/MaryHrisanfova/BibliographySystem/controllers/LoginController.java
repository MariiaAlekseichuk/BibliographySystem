package com.github.MaryHrisanfova.BibliographySystem.controllers;

import com.github.MaryHrisanfova.BibliographySystem.utilities.Methods;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mariia_Khrisanfova
 */
@Controller
@RequestMapping(Paths.LOGIN)
public class LoginController {

    @RequestMapping(Methods.LAYOUT)
    public String getLoginPartialPage(ModelMap modelMap) {
        return (Paths.LOGIN + Methods.LAYOUT);
    }

}
