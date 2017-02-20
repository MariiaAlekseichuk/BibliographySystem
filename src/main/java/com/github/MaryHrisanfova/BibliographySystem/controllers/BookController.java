package com.github.MaryHrisanfova.BibliographySystem.controllers;

import com.github.MaryHrisanfova.BibliographySystem.model.BookDetailed;
import com.github.MaryHrisanfova.BibliographySystem.services.BooksService;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Methods;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Params;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mariia_Khrisanfova
 */
@Controller
@RequestMapping(Paths.BOOK)
public class BookController {
    @Autowired
    private BooksService booksService;

    @RequestMapping("/{bookId}")
    public String getBookLayoutPage(HttpServletRequest request) {
        return (Paths.BOOKS + Methods.BOOK_DETAILS);
    }

    @RequestMapping(method = RequestMethod.GET, value = Methods.SHOW_BOOK_DETAILS)
    public
    @ResponseBody
    BookDetailed getBookById(@RequestParam(Params.BOOK_ID) long bookId) {
        return booksService.getBookById(bookId);
    }

}
