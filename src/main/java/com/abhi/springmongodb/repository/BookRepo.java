package com.abhi.springmongodb.repository;

import com.abhi.springmongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book, Integer>, CustomBookRepository {


}
