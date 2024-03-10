package org.bshg.librarysystem.rack.services;

import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.RackDao;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RackServiceImpl extends ServiceImpl<Rack, RackDao> implements RackService {
    public RackServiceImpl(RackDao dao) {
        super(dao);
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