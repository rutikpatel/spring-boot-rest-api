package org.learn.java;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    public static List<Book> BOOKS = new ArrayList<>();
    public static Map<Integer,Book> bookMap = new HashMap<>();
    static{
        BOOKS.add(new Book(1,"Essential Spring 5"));
        BOOKS.add(new Book(2,"Bhagavad Geeta"));
        BOOKS.add(new Book(3,"Ramayana"));
        BOOKS.add(new Book(4,"Essential hibernate "));

        for(Book book: BOOKS){
            bookMap.put(book.getId(),book);
        }


    }


}
