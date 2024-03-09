
package org.bshg.librarysystem.sprocess.storage.shelf.delete;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.sprocess.storage.shelf.delete.DeleteShelfProcess;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteShelfProcessImpl implements DeleteShelfProcess {
private void process(Shelf item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Shelf item) {
process(item);
deleteAssociated(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Shelf item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Shelf item = service.findById(id);
if (item != null) {
process(item);
deleteAssociated(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Shelf> items) {
items.forEach(this::process);
items.forEach(this::deleteAssociated);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
protected void deleteAssociated(Shelf item) {
if (item == null || item.getId() == null) return;
deleteAssociatedList(item);
}
private void deleteAssociatedList(Shelf item) {
deleteRackProcess.deleteByShelf(item);
}
@Autowired private ShelfService service;
@Autowired @Lazy private RackService rackService;
@Autowired @Lazy private DeleteRackProcess deleteRackProcess;
}