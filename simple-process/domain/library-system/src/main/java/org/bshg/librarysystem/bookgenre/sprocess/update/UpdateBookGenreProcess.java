package org.bshg.librarysystem.bookgenre.sprocess.update;

import org.bshg.librarysystem.bookgenre.BookGenre;

import java.util.List;

public interface UpdateBookGenreProcess {
    BookGenre run(BookGenre item);

    List<BookGenre> run(List<BookGenre> items);
}
