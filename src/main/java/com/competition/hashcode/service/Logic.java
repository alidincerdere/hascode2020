package com.competition.hashcode.service;

import com.competition.hashcode.model.InputModel;
import com.competition.hashcode.model.OutputModel;
import org.springframework.stereotype.Component;

/**
 * Created by adere on 20.02.2020.
 */
@Component
public class Logic {

    private InputModel inputModel;

    private OutputModel outputModel;


    public void run() {

        outputModel = new OutputModel();

        outputModel.setNumOfLibraries(inputModel.getNumOfLibraries());

        outputModel.setLibraryList(inputModel.getLibraries());

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
