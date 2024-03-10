package org.bshg.librarysystem.author.services;

import org.bshg.librarysystem.author.Author;

import java.util.List;

public interface AuthorService {
    Author findById(Long id);

    List<Author> findAllOptimized();

    List<Author> findAll();

    Author create(Author item);

    List<Author> create(List<Author> item);

    Author update(Author item);

    List<Author> update(List<Author> item);

    void deleteById(Long id);

    void delete(Author item);

    void delete(List<Author> items);

    void deleteByIdIn(List<Long> ids);
}