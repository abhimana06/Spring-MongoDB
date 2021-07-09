package com.abhi.springmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Product")
public class Product {

    @Id
    private String productName;

    @Field("imageUrl")
    private String image;
    private int quantity;
    private long price;
}
