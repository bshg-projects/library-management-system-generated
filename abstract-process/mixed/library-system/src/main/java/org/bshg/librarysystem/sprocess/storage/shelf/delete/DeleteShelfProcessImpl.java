package org.bshg.librarysystem.sprocess.storage.shelf.delete;

import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteShelfProcessImpl extends AbstractDeleteProcessImpl<Shelf, ShelfService> implements DeleteShelfProcess {
    public DeleteShelfProcessImpl(ShelfService service, RackService rackService) {
        super(service);
        this.rackService = rackService;
    }

    @Override
    protected void process(Shelf item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void deleteAssociatedList(Shelf item) {
        deleteRackProcess.deleteByShelf(item);
    }

    private RackService rackService;
    private DeleteRackProcess deleteRackProcess;

    public void setDeleteRackProcess(DeleteRackProcess value) {
        this.deleteRackProcess = value;
    }
}