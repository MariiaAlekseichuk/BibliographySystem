package com.github.MaryHrisanfova.BibliographySystem.controllers;

import com.github.MaryHrisanfova.BibliographySystem.utilities.Methods;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Mariia_Khrisanfova
 */
@Controller
@RequestMapping(Paths.ROOT_PAGE)
public class IndexController {
    @RequestMapping
    public String getIndexPage() {
        return Methods.INDEX;
    }
}
