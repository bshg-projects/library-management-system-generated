package org.bshg.librarysystem.sprocess.storage.shelf.create;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.storage.rack.create.CreateRackProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateShelfProcessImpl implements CreateShelfProcess {
    @Transactional(rollbackFor = Exception.class)
    public Shelf run(Shelf item) {
// Your Creation Logic For 'Shelf'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    public List<Shelf> run(List<Shelf> items) {
        items.forEach(this::run);
        return items;
    }

    public void createAssociatedList(Shelf item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Shelf::getRacks, Rack::setShelf, createRackProcess::run);
    }

    @Autowired
    private ShelfService service;
    @Autowired
    private RackService rackService;
    @Autowired
    @Lazy
    private CreateRackProcess createRackProcess;
}