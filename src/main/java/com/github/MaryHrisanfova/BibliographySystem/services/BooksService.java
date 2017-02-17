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
    public List<Book> getAllBooksNames() {
        ClassLoader classLoader = getClass().getClassLoader();
        File bookListFile = new File(classLoader.getResource("bibliography.txt").getFile());
        String jsonData = FileReader.readFile(bookListFile.getPath());
        return JSONReader.selectFiled("id", "name", jsonData);
    }

    public BookDetailed getBookById(long id) {
        ClassLoader classLoader = getClass().getClassLoader();
        File bookListFile = new File(classLoader.getResource("bibliography.txt").getFile());
        String jsonData = FileReader.readFile(bookListFile.getPath());
        ObjectMapper mapper = new ObjectMapper();
        return JSONReader.selectObjectById(id, jsonData);
    }
}
