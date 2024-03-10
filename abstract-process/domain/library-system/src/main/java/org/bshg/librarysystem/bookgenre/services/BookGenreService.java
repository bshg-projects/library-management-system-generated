package org.bshg.librarysystem.bookgenre.services;

import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface BookGenreService extends IService<BookGenre> {
    int deleteByBookId(Long id);

    List<BookGenre> findByBookId(Long id);

    int deleteByGenreId(Long id);

    List<BookGenre> findByGenreId(Long id);
}