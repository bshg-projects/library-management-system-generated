package org.bshg.librarysystem.shelf.sprocess.delete;

import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.services.ShelfService;
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