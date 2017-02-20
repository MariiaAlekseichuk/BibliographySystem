package com.github.MaryHrisanfova.BibliographySystem.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.MaryHrisanfova.BibliographySystem.model.Book;
import com.github.MaryHrisanfova.BibliographySystem.model.BookDetailed;
import com.github.MaryHrisanfova.BibliographySystem.utilities.FileReader;
import com.github.MaryHrisanfova.BibliographySystem.utilities.JSONReader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author Mariia_Khrisanfova
 */
@Service
public class BooksService {
    private static final String BOOKS_TEXT_FILE = "bibliography.txt";

    public List<Book> getAllBooksNames() {
        ClassLoader classLoader = getClass().getClassLoader();
        File bookListFile = new File(classLoader.getResource(BOOKS_TEXT_FILE).getFile());
        String jsonData = FileReader.readFile(bookListFile.getPath());
        return JSONReader.selectFiled("id", "name", jsonData);
    }

    public BookDetailed getBookById(long id) {
        ClassLoader classLoader = getClass().getClassLoader();
        File bookListFile = new File(classLoader.getResource(BOOKS_TEXT_FILE).getFile());
        String jsonData = FileReader.readFile(bookListFile.getPath());
        ObjectMapper mapper = new ObjectMapper();
        return JSONReader.selectObjectById(id, jsonData);
    }
}
