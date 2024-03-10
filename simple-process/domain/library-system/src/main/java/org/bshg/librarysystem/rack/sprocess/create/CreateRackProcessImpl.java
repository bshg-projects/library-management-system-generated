package org.bshg.librarysystem.rack.sprocess.create;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.create.CreateShelfProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateRackProcessImpl implements CreateRackProcess {
    @Transactional(rollbackFor = Exception.class)
    public Rack run(Rack item) {
// Your Creation Logic For 'Rack'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    public List<Rack> run(List<Rack> items) {
        items.forEach(this::run);
        return items;
    }

    public void createAssociatedList(Rack item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Rack::getBooks, Book::setRack, createBookProcess::run);
    }

    @Autowired
    private RackService service;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    private ShelfService shelfService;
    @Autowired
    @Lazy
    private CreateShelfProcess createShelfProcess;
}