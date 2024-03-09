package org.bshg.librarysystem.sprocess.content.authorbook;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.DeleteAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.impl.CreateAuthorBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.authorbook.impl.UpdateAuthorBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.authorbook.impl.DeleteAuthorBookProcessImpl;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.facade.CreateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.facade.UpdateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.facade.DeleteAuthorProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject AuthorBook Processes (Create, Update, Delete).
*/
@Configuration
public class AuthorBookInjector {
@Bean
public CreateAuthorBookProcess createAuthorBookProcess (AuthorBookService service,BookService bookService,AuthorService authorService) {
var bean = new CreateAuthorBookProcessImpl(service, bookService, authorService);
bean.setCreateBookProcess(this.createBookProcess);
bean.setCreateAuthorProcess(this.createAuthorProcess);
return bean;
}
@Bean
public UpdateAuthorBookProcess updateAuthorBookProcess (AuthorBookService service,BookService bookService,AuthorService authorService) {
var bean = new UpdateAuthorBookProcessImpl(service,bookService,authorService);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setUpdateAuthorProcess(this.updateAuthorProcess);
bean.setDeleteAuthorProcess(this.deleteAuthorProcess);
return bean;
}
@Bean
public DeleteAuthorBookProcess deleteAuthorBookProcess(AuthorBookService service,BookService bookService,AuthorService authorService) {
var bean = new DeleteAuthorBookProcessImpl(service,bookService,authorService);
bean.setDeleteAuthorProcess(this.deleteAuthorProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
return bean;
}
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private CreateAuthorProcess createAuthorProcess;
@Autowired @Lazy private UpdateAuthorProcess updateAuthorProcess;
@Autowired @Lazy private DeleteAuthorProcess deleteAuthorProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
}