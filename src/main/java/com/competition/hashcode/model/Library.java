package com.competition.hashcode.model;

import java.util.List;

/**
 * Created by adere on 20.02.2020.
 */
public class Library {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    public int getSignUpDays() {
        return signUpDays;
    }

    public void setSignUpDays(int signUpDays) {
        this.signUpDays = signUpDays;
    }

    public int getShipPerDay() {
        return shipPerDay;
    }

    public void setShipPerDay(int shipPerDay) {
        this.shipPerDay = shipPerDay;
    }

    private int numOfBooks;

    private int signUpDays;

    private int shipPerDay;

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
