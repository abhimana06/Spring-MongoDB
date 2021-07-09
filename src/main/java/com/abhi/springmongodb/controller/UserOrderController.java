package com.abhi.springmongodb.controller;

import com.abhi.springmongodb.model.Book;
import com.abhi.springmongodb.model.User;
import com.abhi.springmongodb.mongoDbData.MongoDBInfo;
import com.abhi.springmongodb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserOrderController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MongoDBInfo mongoDBInfo;

    @PostMapping("/addUserOrder")
    public String addUserOrder(@RequestBody User user){
        userRepo.save(user);
        return "UserOrder saved successfully with UserId:" + user.getId();

    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/getAllUsers/{name}")
    public List<User> getAllUsers(@PathVariable String name){
        return userRepo.findByName(name);
    }

    @GetMapping("/getUsersByAddress/{city}")
    public List<User> getUsersByAddress(@PathVariable String city){
        return userRepo.findByAddress(city);
    }


    @GetMapping("/getInfo")
    public void getInfo (){
        try{
            mongoDBInfo.getMongoBDInfo();
        }catch (Exception ex){

        }

    }
}
