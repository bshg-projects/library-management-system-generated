package org.bshg.librarysystem.sprocess.content.bookgenre.facade;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Genre;

import java.util.List;

public interface DeleteBookGenreProcess {
    void run(BookGenre item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<BookGenre> items);

    void deleteByBook(Book book);

    void deleteByGenre(Genre genre);
}