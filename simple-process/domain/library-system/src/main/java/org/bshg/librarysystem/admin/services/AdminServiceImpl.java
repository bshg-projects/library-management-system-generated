package org.bshg.librarysystem.admin.services;

import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao dao;

    @Override
    public Admin findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Admin> findAll() {
        return dao.findAll();
    }

    public List<Admin> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Admin create(Admin item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Admin edit(Admin item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Admin item) {
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
    public void delete(List<Admin> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }
}