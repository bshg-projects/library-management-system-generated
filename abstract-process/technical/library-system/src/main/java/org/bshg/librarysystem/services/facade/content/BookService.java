package org.bshg.librarysystem.services.facade.content;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface BookService extends IService<Book> {
    int deleteByEmployeeId(Long id);

    List<Book> findByEmployeeId(Long id);

    int deleteByPublisherId(Long id);

    List<Book> findByPublisherId(Long id);

    int deleteByRackId(Long id);

    List<Book> findByRackId(Long id);
}