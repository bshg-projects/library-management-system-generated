package org.bshg.librarysystem.sprocess.storage.rack.delete;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.delete.DeleteShelfProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

import java.util.List;

public class DeleteRackProcessImpl extends AbstractDeleteProcessImpl<Rack, RackService> implements DeleteRackProcess {
    public DeleteRackProcessImpl(RackService service, BookService bookService, ShelfService shelfService) {
        super(service);
        this.bookService = bookService;
        this.shelfService = shelfService;
    }

    @Override
    protected void process(Rack item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByShelf(Shelf shelf) {
        if (shelf != null && shelf.getId() != null) {
            List<Rack> found = this.service.findByShelfId(shelf.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociated);
            service.deleteByShelfId(shelf.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Rack item) {
        deleteBookProcess.deleteByRack(item);
    }

    private BookService bookService;
    private ShelfService shelfService;
    private DeleteBookProcess deleteBookProcess;

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private DeleteShelfProcess deleteShelfProcess;

    public void setDeleteShelfProcess(DeleteShelfProcess value) {
        this.deleteShelfProcess = value;
    }
}