package org.bshg.librarysystem.bookgenre.sprocess.delete;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.genre.Genre;

import java.util.List;

public interface DeleteBookGenreProcess {
    void run(BookGenre item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<BookGenre> items);

    void deleteByBook(Book book);

    void deleteByGenre(Genre genre);
}