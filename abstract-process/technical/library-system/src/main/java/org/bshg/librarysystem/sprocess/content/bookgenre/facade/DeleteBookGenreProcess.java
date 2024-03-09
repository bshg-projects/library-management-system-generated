package org.bshg.librarysystem.sprocess.content.bookgenre.facade;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Genre;
public interface DeleteBookGenreProcess extends IDeleteProcess<BookGenre> {
void deleteByBook(Book book);
void deleteByGenre(Genre genre);
}