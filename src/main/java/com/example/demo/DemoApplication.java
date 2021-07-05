package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {

        SpringApplication.run(DemoApplication.class, args);
	}



}
