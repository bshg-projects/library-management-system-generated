package org.bshg.librarysystem.services.impl.storage;

import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.repository.storage.ShelfDao;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShelfServiceImpl extends ServiceImpl<Shelf, ShelfDao> implements ShelfService {
    public ShelfServiceImpl(ShelfDao dao) {
        super(dao);
    }
}