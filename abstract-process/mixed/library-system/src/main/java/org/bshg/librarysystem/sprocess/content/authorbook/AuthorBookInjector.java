package org.bshg.librarysystem.sprocess.content.authorbook;

import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.author.create.CreateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.delete.DeleteAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.update.UpdateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.create.CreateAuthorBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.authorbook.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.update.UpdateAuthorBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject AuthorBook Processes (Create, Update, Delete).
 */
@Configuration
public class AuthorBookInjector {
    @Bean
    public CreateAuthorBookProcess createAuthorBookProcess(AuthorBookService service, BookService bookService, AuthorService authorService) {
        var bean = new CreateAuthorBookProcessImpl(service, bookService, authorService);
        bean.setCreateBookProcess(this.createBookProcess);
        bean.setCreateAuthorProcess(this.createAuthorProcess);
        return bean;
    }

    @Bean
    public UpdateAuthorBookProcess updateAuthorBookProcess(AuthorBookService service, BookService bookService, AuthorService authorService) {
        var bean = new UpdateAuthorBookProcessImpl(service, bookService, authorService);
        bean.setUpdateBookProcess(this.updateBookProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setUpdateAuthorProcess(this.updateAuthorProcess);
        bean.setDeleteAuthorProcess(this.deleteAuthorProcess);
        return bean;
    }

    @Bean
    public DeleteAuthorBookProcess deleteAuthorBookProcess(AuthorBookService service, BookService bookService, AuthorService authorService) {
        var bean = new DeleteAuthorBookProcessImpl(service, bookService, authorService);
        bean.setDeleteAuthorProcess(this.deleteAuthorProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
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
    private CreateAuthorProcess createAuthorProcess;
    @Autowired
    @Lazy
    private UpdateAuthorProcess updateAuthorProcess;
    @Autowired
    @Lazy
    private DeleteAuthorProcess deleteAuthorProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
}