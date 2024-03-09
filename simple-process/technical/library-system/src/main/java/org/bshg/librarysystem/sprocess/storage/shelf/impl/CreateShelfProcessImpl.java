package org.bshg.librarysystem.sprocess.storage.shelf.impl;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.CreateShelfProcess;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.sprocess.storage.rack.facade.CreateRackProcess;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private ShelfService service;
@Autowired private RackService rackService;
@Autowired @Lazy private CreateRackProcess createRackProcess;
}