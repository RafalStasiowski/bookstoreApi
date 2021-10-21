package com.example.bookstore.controller;


import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books/")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody BookRequestDto bookRequest) {
        bookService.save(modelMapper.map(bookRequest, Book.class));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks().stream().map(book ->
                modelMapper.map(book,BookResponseDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(modelMapper.map(bookService.getBook(id),BookResponseDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(name = "id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
