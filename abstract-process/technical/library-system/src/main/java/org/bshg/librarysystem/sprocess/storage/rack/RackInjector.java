package org.bshg.librarysystem.sprocess.storage.rack;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.sprocess.storage.rack.facade.CreateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.impl.CreateRackProcessImpl;
import org.bshg.librarysystem.sprocess.storage.rack.impl.UpdateRackProcessImpl;
import org.bshg.librarysystem.sprocess.storage.rack.impl.DeleteRackProcessImpl;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.CreateShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.UpdateShelfProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.DeleteShelfProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Rack Processes (Create, Update, Delete).
*/
@Configuration
public class RackInjector {
@Bean
public CreateRackProcess createRackProcess (RackService service,BookService bookService,ShelfService shelfService) {
var bean = new CreateRackProcessImpl(service, bookService, shelfService);
bean.setCreateBookProcess(this.createBookProcess);
bean.setCreateShelfProcess(this.createShelfProcess);
return bean;
}
@Bean
public UpdateRackProcess updateRackProcess (RackService service,BookService bookService,ShelfService shelfService) {
var bean = new UpdateRackProcessImpl(service,bookService,shelfService);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setUpdateShelfProcess(this.updateShelfProcess);
bean.setDeleteShelfProcess(this.deleteShelfProcess);
return bean;
}
@Bean
public DeleteRackProcess deleteRackProcess(RackService service,BookService bookService,ShelfService shelfService) {
var bean = new DeleteRackProcessImpl(service,bookService,shelfService);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setDeleteShelfProcess(this.deleteShelfProcess);
return bean;
}
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private CreateShelfProcess createShelfProcess;
@Autowired @Lazy private UpdateShelfProcess updateShelfProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteShelfProcess deleteShelfProcess;
}