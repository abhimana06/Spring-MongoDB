package com.abhi.springmongodb.repository;

import com.abhi.springmongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {
    List<User> findByName(String name);

    @Query("{'Address.city':?0}")
    List<User> findByAddress(String city);
}
