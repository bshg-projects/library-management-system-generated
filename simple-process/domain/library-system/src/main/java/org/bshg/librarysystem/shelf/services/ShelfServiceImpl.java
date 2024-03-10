package org.bshg.librarysystem.shelf.services;

import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.shelf.ShelfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService {
    @Autowired
    ShelfDao dao;

    @Override
    public Shelf findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Shelf> findAll() {
        return dao.findAll();
    }

    public List<Shelf> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Shelf create(Shelf item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Shelf edit(Shelf item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Shelf item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Shelf> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }
}