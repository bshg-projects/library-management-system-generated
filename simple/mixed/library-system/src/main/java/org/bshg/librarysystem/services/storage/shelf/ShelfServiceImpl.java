package org.bshg.librarysystem.services.storage.shelf;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.repository.storage.ShelfDao;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService {
    //--------------- FIND -------------------------------------
    public Shelf findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Shelf> findAll() {
        return dao.findAll();
    }

    public List<Shelf> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Shelf create(Shelf item) {
        if (item == null) return null;
        Shelf saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Shelf> create(List<Shelf> items) {
        List<Shelf> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Shelf update(Shelf item) {
        if (item == null || item.getId() == null) return null;
        Shelf saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Shelf> update(List<Shelf> items) {
        List<Shelf> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Shelf item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Shelf item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Shelf> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Shelf item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
    public void createAssociatedList(Shelf item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Shelf::getRacks, Rack::setShelf, rackService::create);
    }

    public void updateAssociatedList(Shelf item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, rackService.findByShelfId(item.getId()),
                item.getRacks(), Rack::setShelf,
                rackService::update,
                rackService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Shelf item) {
        deleteAssociatedList(item);
    }

    public void deleteAssociatedList(Shelf item) {
        rackService.deleteByShelfId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private ShelfDao dao;
    @Lazy
    @Autowired
    private RackService rackService;
}