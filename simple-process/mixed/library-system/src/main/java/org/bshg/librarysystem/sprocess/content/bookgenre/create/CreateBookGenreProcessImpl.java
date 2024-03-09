package org.bshg.librarysystem.sprocess.content.bookgenre.create;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.create.CreateBookGenreProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.sprocess.content.genre.create.CreateGenreProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateBookGenreProcessImpl implements CreateBookGenreProcess {
@Transactional(rollbackFor = Exception.class)
public BookGenre run(BookGenre item) {
// Your Creation Logic For 'BookGenre'
item = service.create(item);
return item;
}
public List<BookGenre> run(List<BookGenre> items) {
items.forEach(this::run);
return items;
}
@Autowired private BookGenreService service;
@Autowired private BookService bookService;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired private GenreService genreService;
@Autowired @Lazy private CreateGenreProcess createGenreProcess;
}