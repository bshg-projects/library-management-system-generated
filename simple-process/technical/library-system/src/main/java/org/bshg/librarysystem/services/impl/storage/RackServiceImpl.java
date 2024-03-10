package org.bshg.librarysystem.services.impl.storage;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.repository.storage.RackDao;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.services.facade.storage.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RackServiceImpl implements RackService {
    @Autowired
    RackDao dao;

    @Override
    public Rack findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Rack> findAll() {
        return dao.findAll();
    }

    public List<Rack> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rack create(Rack item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rack edit(Rack item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Rack item) {
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
    public void delete(List<Rack> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByShelfId(Long id) {
        return dao.deleteByShelfId(id);
    }

    @Override
    public List<Rack> findByShelfId(Long id) {
        return dao.findByShelfId(id);
    }

    @Autowired
    private ShelfService shelfService;
}