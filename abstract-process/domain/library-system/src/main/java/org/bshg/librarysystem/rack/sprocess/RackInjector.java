package org.bshg.librarysystem.rack.sprocess;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcessImpl;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcessImpl;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcess;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcessImpl;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.create.CreateShelfProcess;
import org.bshg.librarysystem.shelf.sprocess.delete.DeleteShelfProcess;
import org.bshg.librarysystem.shelf.sprocess.update.UpdateShelfProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Rack Processes (Create, Update, Delete).
 */
@Configuration
public class RackInjector {
    @Bean
    public CreateRackProcess createRackProcess(RackService service, BookService bookService, ShelfService shelfService) {
        var bean = new CreateRackProcessImpl(service, bookService, shelfService);
        bean.setCreateBookProcess(this.createBookProcess);
        bean.setCreateShelfProcess(this.createShelfProcess);
        return bean;
    }

    @Bean
    public UpdateRackProcess updateRackProcess(RackService service, BookService bookService, ShelfService shelfService) {
        var bean = new UpdateRackProcessImpl(service, bookService, shelfService);
        bean.setUpdateBookProcess(this.updateBookProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setUpdateShelfProcess(this.updateShelfProcess);
        bean.setDeleteShelfProcess(this.deleteShelfProcess);
        return bean;
    }

    @Bean
    public DeleteRackProcess deleteRackProcess(RackService service, BookService bookService, ShelfService shelfService) {
        var bean = new DeleteRackProcessImpl(service, bookService, shelfService);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setDeleteShelfProcess(this.deleteShelfProcess);
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
    private CreateShelfProcess createShelfProcess;
    @Autowired
    @Lazy
    private UpdateShelfProcess updateShelfProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteShelfProcess deleteShelfProcess;
}