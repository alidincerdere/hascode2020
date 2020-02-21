package com.competition.hashcode.util;


import com.competition.hashcode.model.Book;
import com.competition.hashcode.model.InputModel;
import com.competition.hashcode.model.Library;
import com.competition.hashcode.model.OutputModel;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by adere on 20.02.2020.
 */

@Component
public class DefaultFileOperator implements FileOperator {

    private String fileName;
    private int numOfRows;

    private InputModel inputModel;
    private OutputModel outputModel;



    public DefaultFileOperator() {


        numOfRows = 0;
        inputModel = new InputModel();
        outputModel = new OutputModel();

    }

    public boolean checkFileExist() {

        FileReader fr = null;

        try {
            fr = new FileReader(fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public int getNumberOfRows() {

        return numOfRows;
    }


    public void readContent() {

        BufferedReader br = null;
        FileReader fr = null;

        List<Library> libraryList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            System.out.println("reading input file...");
            while ((sCurrentLine = br.readLine()) != null) {



                //System.out.println(sCurrentLine);

                if(numOfRows == 0) {
                    //first line

                    String[] firstLine = sCurrentLine.split(" ");

                    inputModel.setNumOfDifferentBooks(Integer.parseInt(firstLine[0]));
                    inputModel.setNumOfLibraries(Integer.parseInt(firstLine[1]));
                    inputModel.setNumOfDays(Integer.parseInt(firstLine[2]));


                }

                if(numOfRows == 1) {

                    String[] secondLine = sCurrentLine.split(" ");

                    for(int i = 0; i<secondLine.length; i++) {

                        Book book = new Book();
                        book.setId(i);
                        book.setScore(Integer.parseInt(secondLine[i]));

                        bookList.add(book);
                    }

                }

                if(numOfRows > 1) {



                    if(numOfRows % 2 == 0) {

                        Library library = new Library();

                        String[] libLine = sCurrentLine.split(" ");

                        library.setId((numOfRows-2)/2);

                        try {
                            library.setNumOfBooks(Integer.parseInt(libLine[0]));
                            library.setSignUpDays(Integer.parseInt(libLine[1]));
                            library.setShipPerDay(Integer.parseInt(libLine[2]));

                            libraryList.add(library);
                        } catch (Exception e) {
                            System.out.println( "number of rows " + numOfRows);
                            continue;
                        }

                    } else {

                        Library library = libraryList.get((numOfRows-3)/2);

                        List<Book> libBooks = new ArrayList<>();

                        String[] libLine = sCurrentLine.split(" ");

                        for (int i=0; i<libLine.length; i++) {

                            Book book = new Book();

                            book.setId(Integer.parseInt(libLine[i]));
                            book.setScore(bookList.get(book.getId()).getScore());

                            libBooks.add(book);
                        }

                        library.setBooks(libBooks);


                        int bookScore = 0;
                        for (Book book: libBooks)
                            bookScore += book.getScore();

                        library.setLibraryScore(bookScore*library.getShipPerDay());

                    }
                }

                numOfRows++;

            }

            inputModel.setLibraries(libraryList);
            inputModel.setBooks(bookList);




        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                //ex.printStackTrace();
                System.out.println(ex.getMessage());

            }

        }


    }

    public void writeWordsToFile(String outputFileName) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(outputFileName);
            bw = new BufferedWriter(fw);

            bw.write(outputModel.getNumOfLibraries() + "\n");

            List<Library> libraries = outputModel.getLibraryList();

            for(Library library : libraries) {

                bw.write(library.getId() + " " + library.getNumOfBooks() + "\n");

                for(Book book : library.getBooks()) {
                    bw.write(book.getId() + " ");
                }
                bw.write("\n");

            }


            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public InputModel getInputModel() {
        return inputModel;
    }


    @Override
    public void setOutputModel(OutputModel outputModel) {
        this.outputModel = outputModel;
    }
}
