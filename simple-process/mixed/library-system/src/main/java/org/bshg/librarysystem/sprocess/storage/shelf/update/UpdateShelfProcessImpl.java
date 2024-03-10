package org.bshg.librarysystem.sprocess.storage.shelf.update;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.update.UpdateRackProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateShelfProcessImpl implements UpdateShelfProcess {
    @Transactional(rollbackFor = Exception.class)
    public Shelf run(Shelf item) { // Your Logic To Update 'Shelf'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    public List<Shelf> run(List<Shelf> items) {
        items.forEach(this::run);
        return items;
    }

    public void updateAssociatedList(Shelf item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                rackService.findByShelfId(item.getId()),
                item.getRacks(),
                Rack::setShelf,
                updateRackProcess::run,
                deleteRackProcess::run
        );
    }

    @Autowired
    private ShelfService service;
    @Autowired
    RackService rackService;
    @Autowired
    @Lazy
    private UpdateRackProcess updateRackProcess;
    @Autowired
    @Lazy
    private DeleteRackProcess deleteRackProcess;
}