package org.bshg.librarysystem.utils.sprocess.impl;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.service.IService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractProcessImpl;

import java.util.List;

public abstract class AbstractUpdateProcessImpl<T extends AuditEntity, S extends IService<T>> extends AbstractProcessImpl<T, S> {
    protected AbstractUpdateProcessImpl(S service) {
        super(service);
    }

    public abstract T run(T item);

    public List<T> run(List<T> items) {
        items.forEach(this::run);
        return items;
    }

    public void updateAssociatedList(T item) { }
}
