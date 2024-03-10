package org.bshg.librarysystem.utils.sprocess.impl;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public abstract class AbstractCreateProcessImpl<T extends AuditEntity, S extends IService<T>> extends AbstractProcessImpl<T, S> {
    protected AbstractCreateProcessImpl(S service) {
        super(service);
    }

    public abstract T run(T item);

    public List<T> run(List<T> items) {
        items.forEach(this::run);
        return items;
    }

    public void createAssociatedList(T item) {
    }
}
