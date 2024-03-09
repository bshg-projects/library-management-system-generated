package org.bshg.librarysystem.bookgenre.sprocess.delete;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.genre.Genre;
public interface DeleteBookGenreProcess extends IDeleteProcess<BookGenre> {
void deleteByBook(Book book);
void deleteByGenre(Genre genre);
}