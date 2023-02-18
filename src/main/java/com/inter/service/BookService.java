package com.inter.service;

import com.inter.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    void saveBook(Book book);

    Book getBook(int id);

    void deleteBook(int id);

}