package org.bshg.librarysystem.sprocess.content.bookgenre;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.impl.CreateBookGenreProcessImpl;
import org.bshg.librarysystem.sprocess.content.bookgenre.impl.UpdateBookGenreProcessImpl;
import org.bshg.librarysystem.sprocess.content.bookgenre.impl.DeleteBookGenreProcessImpl;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.UpdateGenreProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.DeleteGenreProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject BookGenre Processes (Create, Update, Delete).
*/
@Configuration
public class BookGenreInjector {
@Bean
public CreateBookGenreProcess createBookGenreProcess (BookGenreService service,BookService bookService,GenreService genreService) {
var bean = new CreateBookGenreProcessImpl(service, bookService, genreService);
bean.setCreateBookProcess(this.createBookProcess);
bean.setCreateGenreProcess(this.createGenreProcess);
return bean;
}
@Bean
public UpdateBookGenreProcess updateBookGenreProcess (BookGenreService service,BookService bookService,GenreService genreService) {
var bean = new UpdateBookGenreProcessImpl(service,bookService,genreService);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setUpdateGenreProcess(this.updateGenreProcess);
bean.setDeleteGenreProcess(this.deleteGenreProcess);
return bean;
}
@Bean
public DeleteBookGenreProcess deleteBookGenreProcess(BookGenreService service,BookService bookService,GenreService genreService) {
var bean = new DeleteBookGenreProcessImpl(service,bookService,genreService);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setDeleteGenreProcess(this.deleteGenreProcess);
return bean;
}
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private CreateGenreProcess createGenreProcess;
@Autowired @Lazy private UpdateGenreProcess updateGenreProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteGenreProcess deleteGenreProcess;
}