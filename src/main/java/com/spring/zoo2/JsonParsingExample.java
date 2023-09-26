package com.spring.zoo2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.zoo2.module.Config;


@SpringBootApplication
public class JsonParsingExample {

    public static void main(String[] args) throws Exception {
    	String jsonStr = "{\"property1\":\"value1\",\"property2\":\"value2\",\"property3\":\"value3\","
    			+ "\"uri\":\"mongodb://localhost:27017\",\"database\":\"microservice\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        Config config = objectMapper.readValue(jsonStr, Config.class);

        System.out.println("Parsed Config: " + config);
    }
}

