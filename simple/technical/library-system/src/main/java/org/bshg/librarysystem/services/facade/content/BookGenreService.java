package org.bshg.librarysystem.services.facade.content;

import org.bshg.librarysystem.entity.core.content.BookGenre;

import java.util.List;

public interface BookGenreService {
    BookGenre findById(Long id);

    List<BookGenre> findAllOptimized();

    List<BookGenre> findAll();

    BookGenre create(BookGenre item);

    List<BookGenre> create(List<BookGenre> item);

    BookGenre update(BookGenre item);

    List<BookGenre> update(List<BookGenre> item);

    void deleteById(Long id);

    void delete(BookGenre item);

    void delete(List<BookGenre> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByBookId(Long id);

    List<BookGenre> findByBookId(Long id);

    int deleteByGenreId(Long id);

    List<BookGenre> findByGenreId(Long id);
}