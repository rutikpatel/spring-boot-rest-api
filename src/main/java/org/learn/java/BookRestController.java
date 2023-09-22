package org.learn.java;

import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest")
public class BookRestController {

    Map<Integer, Book> bookMap = BookRepository.bookMap;

    @GetMapping(value = "/books",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Book>> getAll(){
        return new ResponseEntity<Collection<Book>>(bookMap.values(),HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getOne(@PathVariable Integer id){
        Book book = bookMap.get(id);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }

    @PostMapping(value = "/books",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Book>> CreateOrAdd(@RequestBody(required = true) Book book){
        bookMap.put(book.getId(), book);
        return new ResponseEntity<Collection<Book>>(bookMap.values(),HttpStatus.CREATED);
    }

    @PutMapping(value = "/books",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> Update(@RequestBody(required = true) Book book){

        if(bookMap.containsKey(book.getId())) {
            bookMap.replace(book.getId(), book);
        }
        else {
            CreateOrAdd(book);
        }
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Book>> Delete(@PathVariable(required = true) Integer id){

        if(bookMap.containsKey(id)){
            bookMap.remove(id);
        }
        return new ResponseEntity<Collection<Book>>(bookMap.values(),HttpStatus.OK);
    }

}
