package com.competition.hashcode.model;

import java.util.List;

/**
 * Created by adere on 20.02.2020.
 */
public class OutputModel {

    private int numOfLibraries;

    private List<Library> libraryList;

    public int getNumOfLibraries() {
        return numOfLibraries;
    }

    public void setNumOfLibraries(int numOfLibraries) {
        this.numOfLibraries = numOfLibraries;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }
}
