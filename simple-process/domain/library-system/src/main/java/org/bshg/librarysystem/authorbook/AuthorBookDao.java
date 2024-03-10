package org.bshg.librarysystem.authorbook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorBookDao extends JpaRepository<AuthorBook, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByAuthorId(Long id);

    List<AuthorBook> findByAuthorId(Long id);

    int deleteByBookId(Long id);

    List<AuthorBook> findByBookId(Long id);
}