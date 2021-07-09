package com.abhi.springmongodb.repository;

public interface CustomBookRepository {

    void partialUpdate(final int id,final String fieldName, final String fieldValue);
}
