package org.bshg.librarysystem.authorbook;

import org.bshg.librarysystem.utils.repository.Repository;

import java.util.List;

public interface AuthorBookDao extends Repository<AuthorBook, Long> {
    int deleteByAuthorId(Long id);

    List<AuthorBook> findByAuthorId(Long id);

    int deleteByBookId(Long id);

    List<AuthorBook> findByBookId(Long id);
}