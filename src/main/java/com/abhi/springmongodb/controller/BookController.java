package com.abhi.springmongodb.controller;

import com.abhi.springmongodb.model.Book;
import com.abhi.springmongodb.repository.BookDAO;
import com.abhi.springmongodb.repository.BookRepo;
import com.abhi.springmongodb.repository.CustomBookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private CustomBookRepositoryImpl customBookRepository;


    @GetMapping ("/welcomeMsg")
    public String getWelcome() {
        return "Welcome ";
    }

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        bookDAO.insertBook(book);
        return "Book saved successfully with Id:" + book.getId();

    }

    @GetMapping ("/getBooks")
    public List<Book> getAllBook(){
        return bookDAO.getAllBook();
    }

    @GetMapping ("/getBooks/{id}")
    public Book getBook(@PathVariable int id){
        //return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found with Id:"+ id));
        return  bookDAO.getBookById(id);
    }

    @DeleteMapping ("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        try {
            bookRepo.deleteById(id);
            return "Book deleted with id: "+ id;
        }catch (Exception e){
            throw new RuntimeException("Book Not found with Id: "+ id);
        }
    }

    @DeleteMapping ("/deleteBookByTemplete/{id}")
    public String deleteBookDAO(@PathVariable int id){
        try {
            bookDAO.deleteById(id);
            return "Book deleted with id: "+ id;
        }catch (Exception e){
            throw new RuntimeException("Book Not found with Id: "+ id);
        }
    }

    @PatchMapping("/updateBook/{id}")
    public void updateBook(@PathVariable int id ,@RequestBody Book book) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(final Field field: Book.class.getDeclaredFields()){
            final String fieldName = field.getName();

            if(fieldName.equalsIgnoreCase("id"))
                continue;
            final Method getter = Book.class.getDeclaredMethod("get" + StringUtils.capitalize(fieldName));
            final Object fieldValue = getter.invoke(book);
            if(Objects.nonNull(fieldValue)){
                customBookRepository.partialUpdate(id,fieldName,fieldValue.toString());
            }
        }
    }

}
