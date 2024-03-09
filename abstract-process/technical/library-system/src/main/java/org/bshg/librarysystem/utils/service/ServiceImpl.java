package org.bshg.librarysystem.utils.service;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ServiceImpl<T extends AuditEntity, REPO extends Repository<T, Long>> {
    protected REPO dao;

    protected ServiceImpl(REPO dao) {
        this.dao = dao;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(T item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<T> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public T create(T item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public T edit(T item) {
        return dao.save(item);
    }

    public T findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public List<T> findAllOptimized() {
        return dao.findAll();
    }
}
