package org.bshg.librarysystem.utils.sprocess.impl;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.service.IService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractProcessImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractDeleteProcessImpl<T extends AuditEntity, S extends IService<T>> extends AbstractProcessImpl<T, S> {
    protected AbstractDeleteProcessImpl(S service) {
        super(service);
    }

    protected abstract void process(T item);

    @Transactional(rollbackFor = Exception.class)
    public void run(T item) {
        process(item);
        deleteAssociated(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        T item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            T item = service.findById(id);
            if (item != null) {
                process(item);
                deleteAssociated(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<T> items) {
        items.forEach(this::process);
        items.forEach(this::deleteAssociated);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(T item) {
        deleteAssociatedList(item);
        deleteAssociatedObjects(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociatedList(T item) {
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociatedObjects(T item) {
    }
}
