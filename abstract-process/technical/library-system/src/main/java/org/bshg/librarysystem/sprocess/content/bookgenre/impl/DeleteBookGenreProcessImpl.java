
package org.bshg.librarysystem.sprocess.content.bookgenre.impl;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.DeleteBookGenreProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.DeleteGenreProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteBookGenreProcessImpl extends AbstractDeleteProcessImpl<BookGenre, BookGenreService> implements DeleteBookGenreProcess {
public DeleteBookGenreProcessImpl(BookGenreService service, BookService bookService, GenreService genreService) {
super(service);
this.bookService = bookService;
this.genreService = genreService;
}
@Override
protected void process(BookGenre item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
public void deleteByBook(Book book) {
if (book != null && book.getId() != null){
service.deleteByBookId(book.getId());
}
}
public void deleteByGenre(Genre genre) {
if (genre != null && genre.getId() != null){
service.deleteByGenreId(genre.getId());
}
}
private BookService bookService;
private GenreService genreService;
private DeleteBookProcess deleteBookProcess;
public void setDeleteBookProcess(DeleteBookProcess value) {
this.deleteBookProcess = value;
}
private DeleteGenreProcess deleteGenreProcess;
public void setDeleteGenreProcess(DeleteGenreProcess value) {
this.deleteGenreProcess = value;
}
}