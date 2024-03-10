package org.bshg.librarysystem.sprocess.storage.shelf.impl;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.storage.rack.facade.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.UpdateShelfProcess;
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