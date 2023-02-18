package com.inter.dao;
import com.inter.entity.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAllBooks();

    void saveBook(Book book);

    Book getBook(int id);

    void deleteBook(int id);

}