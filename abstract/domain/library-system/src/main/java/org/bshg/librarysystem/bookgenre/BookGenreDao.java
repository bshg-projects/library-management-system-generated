package org.bshg.librarysystem.bookgenre;

import org.bshg.librarysystem.utils.repository.Repository;

import java.util.List;

public interface BookGenreDao extends Repository<BookGenre, Long> {
    int deleteByBookId(Long id);

    List<BookGenre> findByBookId(Long id);

    int deleteByGenreId(Long id);

    List<BookGenre> findByGenreId(Long id);
}