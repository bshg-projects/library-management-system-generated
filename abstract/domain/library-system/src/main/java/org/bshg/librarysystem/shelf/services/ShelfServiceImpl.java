
package org.bshg.librarysystem.shelf.services;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.ShelfDao;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
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