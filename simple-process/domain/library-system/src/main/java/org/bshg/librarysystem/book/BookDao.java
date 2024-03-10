package org.bshg.librarysystem.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByEmployeeId(Long id);

    List<Book> findByEmployeeId(Long id);

    int deleteByPublisherId(Long id);

    List<Book> findByPublisherId(Long id);

    int deleteByRackId(Long id);

    List<Book> findByRackId(Long id);

    @Query("SELECT NEW Book(item.id,item.title) FROM Book item")
    List<Book> findAllOptimized();
}