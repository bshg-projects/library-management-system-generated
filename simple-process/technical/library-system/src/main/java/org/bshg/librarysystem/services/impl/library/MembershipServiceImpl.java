package org.bshg.librarysystem.services.impl.library;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.repository.library.MembershipDao;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipDao dao;

    @Override
    public Membership findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Membership> findAll() {
        return dao.findAll();
    }

    public List<Membership> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Membership create(Membership item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Membership edit(Membership item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Membership item) {
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
    public void delete(List<Membership> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByClientId(Long id) {
        return dao.deleteByClientId(id);
    }

    @Override
    public Membership findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    @Autowired
    private ClientService clientService;
}