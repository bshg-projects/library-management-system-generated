package org.bshg.librarysystem.book.services;

import org.bshg.librarysystem.book.Book;

import java.util.List;

public interface BookService {
    Book findById(Long id);

    List<Book> findAllOptimized();

    List<Book> findAll();

    Book create(Book item);

    Book edit(Book item);

    void deleteById(Long id);

    void delete(Book item);

    void delete(List<Book> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByEmployeeId(Long id);

    List<Book> findByEmployeeId(Long id);

    int deleteByPublisherId(Long id);

    List<Book> findByPublisherId(Long id);

    int deleteByRackId(Long id);

    List<Book> findByRackId(Long id);
}