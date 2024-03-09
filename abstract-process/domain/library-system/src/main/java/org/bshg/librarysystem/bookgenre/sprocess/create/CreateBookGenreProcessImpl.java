package org.bshg.librarysystem.bookgenre.sprocess.create;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateBookGenreProcessImpl extends AbstractCreateProcessImpl<BookGenre, BookGenreService> implements CreateBookGenreProcess {
public CreateBookGenreProcessImpl(BookGenreService service, BookService bookService, GenreService genreService) {
super(service);
this.bookService = bookService;
this.genreService = genreService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public BookGenre run(BookGenre item) {
// Your Insert Logic For 'BookGenre'
item = service.create(item);
return item;
}
private BookService bookService;
private CreateBookProcess createBookProcess;
public void setCreateBookProcess(CreateBookProcess value) {
this.createBookProcess = value;
}
private GenreService genreService;
private CreateGenreProcess createGenreProcess;
public void setCreateGenreProcess(CreateGenreProcess value) {
this.createGenreProcess = value;
}
}