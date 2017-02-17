package com.github.MaryHrisanfova.BibliographySystem.model;

import java.io.Serializable;

/**
 * @author Mariia_Khrisanfova
 */
public class Book implements Serializable {
    private long id;
    private String bookName;

    public Book(long id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
