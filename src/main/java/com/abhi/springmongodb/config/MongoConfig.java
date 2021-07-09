package com.abhi.springmongodb.config;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoConfig   {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.database}")
    private String database;
}
