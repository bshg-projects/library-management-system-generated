package org.bshg.librarysystem.services.facade.content;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Author;

import java.util.List;

public interface AuthorBookService {
    AuthorBook findById(Long id);

    List<AuthorBook> findAllOptimized();

    List<AuthorBook> findAll();

    AuthorBook create(AuthorBook item);

    AuthorBook edit(AuthorBook item);

    void deleteById(Long id);

    void delete(AuthorBook item);

    void delete(List<AuthorBook> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByAuthorId(Long id);

    List<AuthorBook> findByAuthorId(Long id);

    int deleteByBookId(Long id);

    List<AuthorBook> findByBookId(Long id);
}