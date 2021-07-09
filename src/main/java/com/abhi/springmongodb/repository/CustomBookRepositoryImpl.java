package com.abhi.springmongodb.repository;

import com.abhi.springmongodb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


//Name has to end with RepositoryImpl if we wish to use different name then
// we have to use @EnableMongoRepositories(repositoryImplementationPostfix = "customSuffixname")
@Repository
public class CustomBookRepositoryImpl implements CustomBookRepository{

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void partialUpdate(int id, String fieldName, String fieldValue) {
        mongoTemplate.findAndModify(BasicQuery.query(Criteria.where("id").is(id)),
                BasicUpdate.update(fieldName,fieldValue), FindAndModifyOptions.none(), Book.class);
    }
}
