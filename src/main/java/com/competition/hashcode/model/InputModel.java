package com.competition.hashcode.model;

import java.util.List;

/**
 * Created by adere on 20.02.2020.
 */
public class InputModel {

    private int numOfDifferentBooks;

    private int numOfLibraries;

    private int numOfDays;

    private List<Book> books;

    private List<Library> libraries;

    public int getNumOfDifferentBooks() {
        return numOfDifferentBooks;
    }

    public void setNumOfDifferentBooks(int numOfDifferentBooks) {
        this.numOfDifferentBooks = numOfDifferentBooks;
    }

    public int getNumOfLibraries() {
        return numOfLibraries;
    }

    public void setNumOfLibraries(int numOfLibraries) {
        this.numOfLibraries = numOfLibraries;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
