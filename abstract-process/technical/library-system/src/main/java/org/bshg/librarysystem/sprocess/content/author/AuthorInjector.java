package org.bshg.librarysystem.sprocess.content.author;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.sprocess.content.author.facade.CreateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.facade.UpdateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.facade.DeleteAuthorProcess;
import org.bshg.librarysystem.sprocess.content.author.impl.CreateAuthorProcessImpl;
import org.bshg.librarysystem.sprocess.content.author.impl.UpdateAuthorProcessImpl;
import org.bshg.librarysystem.sprocess.content.author.impl.DeleteAuthorProcessImpl;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.DeleteAuthorBookProcess;
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