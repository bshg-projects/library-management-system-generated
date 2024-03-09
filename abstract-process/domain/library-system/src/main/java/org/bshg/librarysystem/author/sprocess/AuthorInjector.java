package org.bshg.librarysystem.author.sprocess;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.author.sprocess.create.CreateAuthorProcess;
import org.bshg.librarysystem.author.sprocess.update.UpdateAuthorProcess;
import org.bshg.librarysystem.author.sprocess.delete.DeleteAuthorProcess;
import org.bshg.librarysystem.author.sprocess.create.CreateAuthorProcessImpl;
import org.bshg.librarysystem.author.sprocess.update.UpdateAuthorProcessImpl;
import org.bshg.librarysystem.author.sprocess.delete.DeleteAuthorProcessImpl;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Author Processes (Create, Update, Delete).
*/
@Configuration
public class AuthorInjector {
@Bean
public CreateAuthorProcess createAuthorProcess (AuthorService service,AuthorBookService authorBookService) {
var bean = new CreateAuthorProcessImpl(service, authorBookService);
bean.setCreateAuthorBookProcess(this.createAuthorBookProcess);
return bean;
}
@Bean
public UpdateAuthorProcess updateAuthorProcess (AuthorService service,AuthorBookService authorBookService) {
var bean = new UpdateAuthorProcessImpl(service,authorBookService);
bean.setUpdateAuthorBookProcess(this.updateAuthorBookProcess);
bean.setDeleteAuthorBookProcess(this.deleteAuthorBookProcess);
return bean;
}
@Bean
public DeleteAuthorProcess deleteAuthorProcess(AuthorService service,AuthorBookService authorBookService) {
var bean = new DeleteAuthorProcessImpl(service,authorBookService);
bean.setDeleteAuthorBookProcess(this.deleteAuthorBookProcess);
return bean;
}
@Autowired @Lazy private CreateAuthorBookProcess createAuthorBookProcess;
@Autowired @Lazy private UpdateAuthorBookProcess updateAuthorBookProcess;
@Autowired @Lazy private DeleteAuthorBookProcess deleteAuthorBookProcess;
}