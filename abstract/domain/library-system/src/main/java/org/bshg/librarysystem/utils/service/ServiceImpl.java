package org.bshg.librarysystem.utils.service;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public abstract class ServiceImpl<T extends AuditEntity, REPO extends Repository<T, Long>> {

    protected REPO dao;

    protected ServiceImpl(REPO dao) {
        this.dao = dao;
    }

    //--------------- FIND -------------------------------------
    public T findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public List<T> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    protected void createAssociatedList(T item) {
    }

    @Transactional(rollbackFor = Exception.class)
    public T create(T item) {
        if (item == null) return null;
        T saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> create(List<T> items) {
        List<T> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    protected void updateAssociatedList(T item) {
    }

    @Transactional(rollbackFor = Exception.class)
    public T update(T item) {
        if (item == null || item.getId() == null) return null;
        T saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> update(List<T> items) {
        List<T> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    protected void preDelete(T item) {
    }

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociatedList(T item) {
    }

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociatedObjects(T item) {
    }

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociated(T item) {
        deleteAssociatedList(item);
        deleteAssociatedObjects(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        T item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(T item) {
        preDelete(item);
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<T> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            T item = findById(id);
            if (item != null) {
                preDelete(item);
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }
}
