package com.abhi.springmongodb.repository;

import com.abhi.springmongodb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;


import java.util.List;
//For more control over the Data and interaction with the MongoDB we use MongoTemplate over MongoRepository
//Both MongoTemplate and MongoRepository do the same job
@Repository
public class BookDAO {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void insertBook(final Book book){
        mongoTemplate.insert(book);
    }

    public List<Book> getAllBook(){
        return mongoTemplate.findAll(Book.class);
    }

    public Book getBookById( int id){
        return mongoTemplate.findById(id, Book.class);
    }

    public void deleteById(int id){
        mongoTemplate.remove(BasicQuery.query(Criteria.where("id").is(id)), Book.class);
    }


}
