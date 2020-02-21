package com.competition.hashcode;

import com.competition.hashcode.service.Logic;
import com.competition.hashcode.util.FileOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class HashcodeApplication implements CommandLineRunner {

	@Autowired
	FileOperator myFileOperator;

	@Autowired
	Logic logic;

	private static Logger LOG = LoggerFactory
			.getLogger(HashcodeApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(HashcodeApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		//Code here!!!

		//myFileOperator.setFileName("a_example.txt");
		//myFileOperator.setFileName("b_read_on.txt");

		//myFileOperator.setFileName("c_incunabula.txt");
		//myFileOperator.setFileName("d_tough_choices.txt");
		//myFileOperator.setFileName("e_so_many_books.txt");
		myFileOperator.setFileName("f_libraries_of_the_world.txt");

		myFileOperator.readContent();


		logic.setInputModel(myFileOperator.getInputModel());

		logic.run();


		myFileOperator.setOutputModel(logic.getOutputModel());

		myFileOperator.writeWordsToFile("output_f.txt");

		LOG.info("EXECUTING : Pythoncular işiniz bitince bize yardım ediyorsunuz");


	}
}