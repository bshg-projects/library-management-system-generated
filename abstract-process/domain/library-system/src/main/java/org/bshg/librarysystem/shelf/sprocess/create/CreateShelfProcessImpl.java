package org.bshg.librarysystem.shelf.sprocess.create;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.create.CreateShelfProcess;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateShelfProcessImpl extends AbstractCreateProcessImpl<Shelf, ShelfService> implements CreateShelfProcess {
public CreateShelfProcessImpl(ShelfService service, RackService rackService) {
super(service);
this.rackService = rackService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Shelf run(Shelf item) {
// Your Insert Logic For 'Shelf'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Shelf item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Shelf::getRacks, Rack::setShelf, createRackProcess);
}
private RackService rackService;
private CreateRackProcess createRackProcess;
public void setCreateRackProcess(CreateRackProcess value) {
this.createRackProcess = value;
}
}