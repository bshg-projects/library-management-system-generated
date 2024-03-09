package org.bshg.librarysystem.sprocess.storage.shelf.impl;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.UpdateShelfProcess;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.sprocess.storage.rack.facade.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.DeleteRackProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private ShelfService service;
@Autowired RackService rackService;
@Autowired @Lazy private UpdateRackProcess updateRackProcess;
@Autowired @Lazy private DeleteRackProcess deleteRackProcess;
}