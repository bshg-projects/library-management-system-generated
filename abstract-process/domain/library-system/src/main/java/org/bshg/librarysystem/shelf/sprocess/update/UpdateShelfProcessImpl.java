package org.bshg.librarysystem.shelf.sprocess.update;

import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcess;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateShelfProcessImpl extends AbstractUpdateProcessImpl<Shelf, ShelfService> implements UpdateShelfProcess {
    public UpdateShelfProcessImpl(ShelfService service, RackService rackService) {
        super(service);
        this.rackService = rackService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Shelf run(Shelf item) {
// Your Update Logic For 'Shelf'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Shelf item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                rackService::findByShelfId,
                Shelf::getRacks,
                Rack::setShelf,
                updateRackProcess,
                deleteRackProcess
        );
    }

    private RackService rackService;
    private UpdateRackProcess updateRackProcess;
    private DeleteRackProcess deleteRackProcess;

    public void setUpdateRackProcess(UpdateRackProcess value) {
        this.updateRackProcess = value;
    }

    public void setDeleteRackProcess(DeleteRackProcess value) {
        this.deleteRackProcess = value;
    }
}