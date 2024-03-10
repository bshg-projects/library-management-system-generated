package org.bshg.librarysystem.sprocess.storage.rack.impl;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.CreateRackProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.CreateShelfProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateRackProcessImpl extends AbstractCreateProcessImpl<Rack, RackService> implements CreateRackProcess {
    public CreateRackProcessImpl(RackService service, BookService bookService, ShelfService shelfService) {
        super(service);
        this.bookService = bookService;
        this.shelfService = shelfService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Rack run(Rack item) {
// Your Insert Logic For 'Rack'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Rack item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Rack::getBooks, Book::setRack, createBookProcess);
    }

    private BookService bookService;
    private CreateBookProcess createBookProcess;

    public void setCreateBookProcess(CreateBookProcess value) {
        this.createBookProcess = value;
    }

    private ShelfService shelfService;
    private CreateShelfProcess createShelfProcess;

    public void setCreateShelfProcess(CreateShelfProcess value) {
        this.createShelfProcess = value;
    }
}