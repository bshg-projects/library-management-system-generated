package org.bshg.librarysystem.sprocess.content.bookgenre.delete;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteBookGenreProcess extends IDeleteProcess<BookGenre> {
    void deleteByBook(Book book);

    void deleteByGenre(Genre genre);
}