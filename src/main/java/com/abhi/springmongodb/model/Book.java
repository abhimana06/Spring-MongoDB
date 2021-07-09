package com.abhi.springmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Book")
public class Book {
    @Id
    private int id;
    private String bookName;
    private String authorName;
}
