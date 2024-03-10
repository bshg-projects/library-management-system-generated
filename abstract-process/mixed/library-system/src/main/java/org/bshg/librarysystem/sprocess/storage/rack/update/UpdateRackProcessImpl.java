package org.bshg.librarysystem.sprocess.storage.rack.update;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.delete.DeleteShelfProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.update.UpdateShelfProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateRackProcessImpl extends AbstractUpdateProcessImpl<Rack, RackService> implements UpdateRackProcess {
    public UpdateRackProcessImpl(RackService service, BookService bookService, ShelfService shelfService) {
        super(service);
        this.bookService = bookService;
        this.shelfService = shelfService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Rack run(Rack item) {
// Your Update Logic For 'Rack'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Rack item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                bookService::findByRackId,
                Rack::getBooks,
                Book::setRack,
                updateBookProcess,
                deleteBookProcess
        );
    }

    private BookService bookService;
    private UpdateBookProcess updateBookProcess;
    private DeleteBookProcess deleteBookProcess;

    public void setUpdateBookProcess(UpdateBookProcess value) {
        this.updateBookProcess = value;
    }

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private ShelfService shelfService;
    private UpdateShelfProcess updateShelfProcess;
    private DeleteShelfProcess deleteShelfProcess;

    public void setUpdateShelfProcess(UpdateShelfProcess value) {
        this.updateShelfProcess = value;
    }

    public void setDeleteShelfProcess(DeleteShelfProcess value) {
        this.deleteShelfProcess = value;
    }
}