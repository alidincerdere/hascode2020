package com.competition.hashcode.model;

import java.util.Comparator;
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

    private int libraryScore;

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public static class Comparators {

        public static Comparator<Library> SIGNUPDAY = new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                return o1.signUpDays - o2.signUpDays;
            }
        };


        public static Comparator<Library> SIGNUPDAYANDNUMOFBOOKS = new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                int i = o1.signUpDays - o2.signUpDays;
                if (i == 0) {
                    i = o2.numOfBooks - o1.numOfBooks;
                }
                return i;
            }
        };

        public static Comparator<Library> SIGNUPDAYANDSCORE = new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                int i = o1.signUpDays - o2.signUpDays;
                if (i == 0) {
                    i = o2.libraryScore - o1.libraryScore;
                }
                return i;
            }
        };

        public static Comparator<Library> SCOREANDSIGNUPDAY = new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                int i = o2.libraryScore - o1.libraryScore;

                if (i == 0) {
                    i = o1.signUpDays - o2.signUpDays;
                }
                return i;
            }
        };

    }

    public int getLibraryScore() {
        return libraryScore;
    }

    public void setLibraryScore(int libraryScore) {
        this.libraryScore = libraryScore;
    }
}
