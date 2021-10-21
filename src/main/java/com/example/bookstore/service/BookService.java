package com.example.bookstore.service;

import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public List<Book> getBooksInRange(long idStart, long idEnd) {
        List<Book> books = new ArrayList<>();
        for(long i=idStart;i<idEnd;i++) {
            books.add(getBook(i));
        }
        return books;
    }

    public void deleteBook(long id) {
        Book book = bookRepository.findById(id);
        bookRepository.delete(book);
    }

}
