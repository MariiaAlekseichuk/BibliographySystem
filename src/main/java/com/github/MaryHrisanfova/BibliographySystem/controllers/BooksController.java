package com.github.MaryHrisanfova.BibliographySystem.controllers;

import com.github.MaryHrisanfova.BibliographySystem.model.Book;
import com.github.MaryHrisanfova.BibliographySystem.services.BooksService;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Methods;
import com.github.MaryHrisanfova.BibliographySystem.utilities.Paths;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.github.MaryHrisanfova.BibliographySystem.utilities.Params.USER_NAME;

/**
 * @author Mariia_Khrisanfova
 */
@Controller
@RequestMapping(Paths.BOOKS)
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping(Methods.LAYOUT)
    public String getBooksLayoutPage(HttpServletRequest request) {

        if (request.getSession().getAttribute(USER_NAME) != null) {
            return (Paths.BOOKS + Methods.LAYOUT);
        } else return "errors/403";
    }

    @RequestMapping(Methods.BOOK_DETAILS)
    public String getBookDetailsPage() {
        return Paths.BOOKS + Methods.BOOK_DETAILS;
    }

    @RequestMapping(method = RequestMethod.GET, value = Methods.ALL_BOOKS)
    public
    @ResponseBody
    List<Book> getAllBooksNames(HttpServletRequest request) throws JSONException {
        if (request.getSession().getAttribute(USER_NAME) != null) {
            return booksService.getAllBooksNames();
        } else return null;
    }
}
