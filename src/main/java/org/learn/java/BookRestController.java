package org.learn.java;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/api/rest")
@RestController
public class BookRestController {
    List<Book> books = BookRepository.BOOKS;
    Map<Integer,Book> bookMap = BookRepository.bookMap;
    @GetMapping(value = "/books",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping(value = "/books/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> getOne(@PathVariable Integer id){

        Book book = bookMap.get(id);
        if(book == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @PostMapping(value = "/books/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> createOrAdd(@RequestBody Book book){
        books.add(book);
        bookMap.put(book.getId(),book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);

    }

}
