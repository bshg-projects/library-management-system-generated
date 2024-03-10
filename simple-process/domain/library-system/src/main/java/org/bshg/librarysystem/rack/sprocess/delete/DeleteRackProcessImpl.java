package org.bshg.librarysystem.rack.sprocess.delete;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.delete.DeleteShelfProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteRackProcessImpl implements DeleteRackProcess {
    private void process(Rack item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Rack item) {
        process(item);
        deleteAssociated(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Rack item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Rack item = service.findById(id);
            if (item != null) {
                process(item);
                deleteAssociated(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Rack> items) {
        items.forEach(this::process);
        items.forEach(this::deleteAssociated);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByShelf(Shelf shelf) {
        if (shelf != null && shelf.getId() != null) {
            List<Rack> found = this.service.findByShelfId(shelf.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociated);
            service.deleteByShelfId(shelf.getId());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociated(Rack item) {
        if (item == null || item.getId() == null) return;
        deleteAssociatedList(item);
    }

    private void deleteAssociatedList(Rack item) {
        deleteBookProcess.deleteByRack(item);
    }

    @Autowired
    private RackService service;
    @Autowired
    @Lazy
    private BookService bookService;
    @Autowired
    @Lazy
    private ShelfService shelfService;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteShelfProcess deleteShelfProcess;
}