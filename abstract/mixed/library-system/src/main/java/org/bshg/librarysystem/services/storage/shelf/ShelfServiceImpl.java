package org.bshg.librarysystem.services.storage.shelf;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.repository.storage.ShelfDao;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
        ServiceHelper.updateList(item, rackService::findByShelfId, Shelf::getRacks, Rack::setShelf, rackService);
    }

    @Lazy
    @Autowired
    private RackService rackService;
}