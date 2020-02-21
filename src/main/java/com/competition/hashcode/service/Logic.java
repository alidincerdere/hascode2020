package com.competition.hashcode.service;

import com.competition.hashcode.model.Book;
import com.competition.hashcode.model.InputModel;
import com.competition.hashcode.model.Library;
import com.competition.hashcode.model.OutputModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by adere on 20.02.2020.
 */
@Component
public class Logic {

    private InputModel inputModel;

    private OutputModel outputModel;


    public void sortBySignUpDays() {

        List<Library> sortedLibraryList = inputModel.getLibraries();

        Collections.sort(sortedLibraryList,Library.Comparators.SIGNUPDAYANDSCORE);

        inputModel.setLibraries(sortedLibraryList);

    }

    public void sortByScore() {

        for (Library library : inputModel.getLibraries()) {
            List<Book> sortedBookList = library.getBooks();

            Collections.sort(sortedBookList,Book.Comparators.SCORE);

            library.setBooks(sortedBookList);
        }
    }




    public void run() {

        sortBySignUpDays();
        sortByScore();

        outputModel = new OutputModel();

        List<Library> outputLibraryList = new ArrayList<>();




        int numOfDaysRemaining = inputModel.getNumOfDays();

        for (int i=0; i< inputModel.getNumOfLibraries(); i++) {

            Library inputLibrary = inputModel.getLibraries().get(i);

            numOfDaysRemaining = numOfDaysRemaining - inputLibrary.getSignUpDays();

            if(numOfDaysRemaining<=0) {
                break;
            }

            int bookIndex =  numOfDaysRemaining * inputLibrary.getShipPerDay() > inputLibrary.getNumOfBooks() ? inputLibrary.getNumOfBooks() : numOfDaysRemaining * inputLibrary.getShipPerDay();

            if(bookIndex <= 0) {
                continue;
            }
            List<Book> outputBooks = inputLibrary.getBooks().subList(0, bookIndex);

            Library outputLibrary = new Library();
            outputLibrary.setBooks(outputBooks);
            outputLibrary.setId(inputLibrary.getId());
            outputLibrary.setNumOfBooks(outputBooks.size());

            outputLibraryList.add(outputLibrary);
        }


        outputModel.setNumOfLibraries(outputLibraryList.size());
        outputModel.setLibraryList(outputLibraryList);

        //outputModel.setNumOfLibraries(inputModel.getNumOfLibraries());

        //outputModel.setLibraryList(inputModel.getLibraries());

    }

    public InputModel getInputModel() {
        return inputModel;
    }

    public void setInputModel(InputModel inputModel) {
        this.inputModel = inputModel;
    }

    public OutputModel getOutputModel() {
        return outputModel;
    }

    public void setOutputModel(OutputModel outputModel) {
        this.outputModel = outputModel;
    }
}
