package org.bshg.librarysystem.rack.services;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.RackDao;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RackServiceImpl extends ServiceImpl<Rack, RackDao> implements RackService {
    public RackServiceImpl(RackDao dao) {
        super(dao);
    }

    @Override
    public void deleteAssociatedList(Rack item) {
        if (item == null || item.getId() == null) return;
        bookService.deleteByRackId(item.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByShelfId(Long id) {
        if (id == null) return 0;
        List<Rack> found = findByShelfId(id);
        if (found == null) return 0;
        found.forEach(this::deleteAssociated);
        return dao.deleteByShelfId(id);
    }

    @Override
    public List<Rack> findByShelfId(Long id) {
        return dao.findByShelfId(id);
    }

    @Override
    public void createAssociatedList(Rack item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Rack::getBooks, Book::setRack, bookService);
    }

    @Override
    public void updateAssociatedList(Rack item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(item, bookService::findByRackId, Rack::getBooks, Book::setRack, bookService);
    }

    @Lazy
    @Autowired
    private BookService bookService;
    @Lazy
    @Autowired
    private ShelfService shelfService;
}