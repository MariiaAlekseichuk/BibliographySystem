package com.github.MaryHrisanfova.BibliographySystem.model;

import java.io.Serializable;

/**
 * @author Mariia_Khrisanfova
 */
public class BookDetailed implements Serializable {
    private long id;
    private String name;
    private String author;
    private short year_of_publishing;
    private short number_of_pages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public short getYear_of_publishing() {
        return year_of_publishing;
    }

    public void setYear_of_publishing(short year_of_publishing) {
        this.year_of_publishing = year_of_publishing;
    }

    public short getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(short number_of_pages) {
        this.number_of_pages = number_of_pages;
    }
}
