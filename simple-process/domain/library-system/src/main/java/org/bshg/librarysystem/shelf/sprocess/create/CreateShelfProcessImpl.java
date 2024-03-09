package org.bshg.librarysystem.shelf.sprocess.create;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.create.CreateShelfProcess;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.rack.Rack;
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