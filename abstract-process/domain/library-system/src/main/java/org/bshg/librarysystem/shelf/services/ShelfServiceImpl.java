package org.bshg.librarysystem.shelf.services;

import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.ShelfDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShelfServiceImpl extends ServiceImpl<Shelf, ShelfDao> implements ShelfService {
    public ShelfServiceImpl(ShelfDao dao) {
        super(dao);
    }
}