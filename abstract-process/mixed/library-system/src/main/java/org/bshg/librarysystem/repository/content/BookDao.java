package org.bshg.librarysystem.repository.content;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends Repository<Book, Long> {
    int deleteByEmployeeId(Long id);

    List<Book> findByEmployeeId(Long id);

    int deleteByPublisherId(Long id);

    List<Book> findByPublisherId(Long id);

    int deleteByRackId(Long id);

    List<Book> findByRackId(Long id);

    @Query("SELECT NEW Book(item.id,item.title) FROM Book item")
    List<Book> findAllOptimized();
}