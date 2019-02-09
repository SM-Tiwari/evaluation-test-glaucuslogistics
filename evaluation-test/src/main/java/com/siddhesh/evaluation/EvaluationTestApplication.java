package com.siddhesh.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EvaluationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluationTestApplication.class, args);
	}

}

