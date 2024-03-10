package org.bshg.librarysystem.rack.sprocess.delete;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.delete.DeleteShelfProcess;
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