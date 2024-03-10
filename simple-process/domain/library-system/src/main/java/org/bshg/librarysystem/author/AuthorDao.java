package org.bshg.librarysystem.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorDao extends JpaRepository<Author, Long> {
    int deleteByIdIn(List<Long> ids);
}