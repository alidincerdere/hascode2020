package com.competition.hashcode.model;

import java.util.Comparator;

/**
 * Created by adere on 20.02.2020.
 */
public class Book {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;



    public static class Comparators {

        public static Comparator<Book> SCORE = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.score - o1.score;
            }
        };


    }
}
