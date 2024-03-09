package org.bshg.librarysystem.sprocess.storage.shelf.update;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.update.UpdateShelfProcess;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.sprocess.storage.rack.update.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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