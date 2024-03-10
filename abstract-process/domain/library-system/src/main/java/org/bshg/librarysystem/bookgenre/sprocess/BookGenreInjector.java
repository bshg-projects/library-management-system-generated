package org.bshg.librarysystem.bookgenre.sprocess;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcessImpl;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcessImpl;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcessImpl;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.genre.sprocess.update.UpdateGenreProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject BookGenre Processes (Create, Update, Delete).
 */
@Configuration
public class BookGenreInjector {
    @Bean
    public CreateBookGenreProcess createBookGenreProcess(BookGenreService service, BookService bookService, GenreService genreService) {
        var bean = new CreateBookGenreProcessImpl(service, bookService, genreService);
        bean.setCreateBookProcess(this.createBookProcess);
        bean.setCreateGenreProcess(this.createGenreProcess);
        return bean;
    }

    @Bean
    public UpdateBookGenreProcess updateBookGenreProcess(BookGenreService service, BookService bookService, GenreService genreService) {
        var bean = new UpdateBookGenreProcessImpl(service, bookService, genreService);
        bean.setUpdateBookProcess(this.updateBookProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setUpdateGenreProcess(this.updateGenreProcess);
        bean.setDeleteGenreProcess(this.deleteGenreProcess);
        return bean;
    }

    @Bean
    public DeleteBookGenreProcess deleteBookGenreProcess(BookGenreService service, BookService bookService, GenreService genreService) {
        var bean = new DeleteBookGenreProcessImpl(service, bookService, genreService);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setDeleteGenreProcess(this.deleteGenreProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    @Lazy
    private UpdateBookProcess updateBookProcess;
    @Autowired
    @Lazy
    private CreateGenreProcess createGenreProcess;
    @Autowired
    @Lazy
    private UpdateGenreProcess updateGenreProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteGenreProcess deleteGenreProcess;
}