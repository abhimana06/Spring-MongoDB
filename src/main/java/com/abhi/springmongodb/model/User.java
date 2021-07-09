package com.abhi.springmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User {


    @Id
    private int id;
    private String name;
    private String gender;
    //No Need to indicate OneToMany or OneToOne in MongoDB
    private List<Product> products;
    private Address address;

}
