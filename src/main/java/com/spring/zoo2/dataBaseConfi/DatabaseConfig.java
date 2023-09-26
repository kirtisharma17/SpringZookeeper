//package com.spring.zoo2.dataBaseConfi;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.spring.zoo2.module.MongoDBConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//@Configuration
//public class DatabaseConfig {
//	 
//	private MongoDBConfig mongoDBConfig;
//	
//	@Bean
//	    public MongoClient mongoClient() {
//	        // Fetch MongoDB configuration from external source, e.g., ZooKeeper
//	        String host = mongoDBConfig.getHost();
//	        int port = mongoDBConfig.getPort();
//
//	        ConnectionString connectionString = new ConnectionString("mongodb://" + host + ":" + port);
//	        MongoClientSettings settings = MongoClientSettings.builder()
//	            .applyConnectionString(connectionString)
//	            // Other settings like authentication, SSL, etc.
//	            .build();
//
//	        return MongoClients.create(settings);
//	    }
//
//	    @Bean
//	    public MongoTemplate mongoTemplate() {
//	        return new MongoTemplate(mongoClient(), mongoDBConfig.getDatabase());
//	    }
//	}
//    
