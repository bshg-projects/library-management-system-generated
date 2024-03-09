
package org.bshg.librarysystem.services.impl.storage;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.repository.storage.ShelfDao;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ShelfServiceImpl extends ServiceImpl<Shelf, ShelfDao> implements ShelfService {
public ShelfServiceImpl(ShelfDao dao) {
super(dao);
}
@Override
public void deleteAssociatedList(Shelf item) {
if (item == null || item.getId() == null) return;
rackService.deleteByShelfId(item.getId());
}
@Override
public void createAssociatedList(Shelf item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Shelf::getRacks, Rack::setShelf, rackService);
}
@Override
public void updateAssociatedList(Shelf item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,rackService::findByShelfId,Shelf::getRacks,Rack::setShelf,rackService);
}
@Lazy @Autowired private RackService rackService;
}