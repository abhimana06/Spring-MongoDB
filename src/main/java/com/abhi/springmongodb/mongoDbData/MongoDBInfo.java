package com.abhi.springmongodb.mongoDbData;

import com.mongodb.Block;
import com.mongodb.client.*;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Slf4j
@Service
public class MongoDBInfo {

    private final String uri = "";
    public void getMongoBDInfo() throws FileNotFoundException {
        MongoClient mongoClient = MongoClients.create();
        MongoIterable<String> databases = mongoClient.listDatabaseNames();
        for (String dbName:databases) {
           log.info("dbName:"+dbName);
        }
        MongoDatabase mongoDb = mongoClient.getDatabase("BookStore");
        MongoCollection mongoCollection = mongoDb.getCollection("Book");
        MongoIterable<Document> documentMongoCollection = mongoCollection.find();
        for (Document document: documentMongoCollection) {
            log.info("document:"+document.toJson());
        }
        GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDb, "imageBucket");
        gridFSBucket.uploadFromStream("image", new FileInputStream(new File("/Users/abhishek/Downloads/TimeSheetErr.jpg")));

    }


       
        
    

}
