package com.inter.dao;

import com.inter.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks() {
        Session session = entityManager.unwrap(Session.class);

        Query<Book> query = session.createQuery("from Book", Book.class);
        List<Book> allBooks = query.getResultList();

        return allBooks;
    }

    @Override
    public void saveBook(Book book) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(book);
    }

    @Override
    public Book getBook(int id) {
        Session session = entityManager.unwrap(Session.class);
        Book book = session.get(Book.class, id);

        return book;
    }

    @Override
    public void deleteBook(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Book> query = session.createQuery("delete from Book " + "where id =:bookId");
        query.setParameter("bookId", id);
        query.executeUpdate();
    }

}