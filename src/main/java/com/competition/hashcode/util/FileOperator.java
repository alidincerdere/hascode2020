package com.competition.hashcode.util;

import com.competition.hashcode.model.InputModel;
import com.competition.hashcode.model.OutputModel;

import java.util.List;

/**
 * Created by adere on 9.05.2019.
 */
public interface FileOperator {

    boolean checkFileExist();

    int getNumberOfRows();


    void readContent();

    void writeWordsToFile(String outputFile);


    void setFileName(String filename);

    InputModel getInputModel();

    void setOutputModel(OutputModel outputModel);



}

