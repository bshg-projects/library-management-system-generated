package org.bshg.librarysystem.bookgenre.sprocess.create;

import org.bshg.librarysystem.bookgenre.BookGenre;

import java.util.List;

public interface CreateBookGenreProcess {
    BookGenre run(BookGenre item);

    List<BookGenre> run(List<BookGenre> items);
}