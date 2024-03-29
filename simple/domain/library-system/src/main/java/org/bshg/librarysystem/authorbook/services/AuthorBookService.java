package org.bshg.librarysystem.authorbook.services;

import org.bshg.librarysystem.authorbook.AuthorBook;

import java.util.List;

public interface AuthorBookService {
    AuthorBook findById(Long id);

    List<AuthorBook> findAllOptimized();

    List<AuthorBook> findAll();

    AuthorBook create(AuthorBook item);

    List<AuthorBook> create(List<AuthorBook> item);

    AuthorBook update(AuthorBook item);

    List<AuthorBook> update(List<AuthorBook> item);

    void deleteById(Long id);

    void delete(AuthorBook item);

    void delete(List<AuthorBook> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByAuthorId(Long id);

    List<AuthorBook> findByAuthorId(Long id);

    int deleteByBookId(Long id);

    List<AuthorBook> findByBookId(Long id);
}