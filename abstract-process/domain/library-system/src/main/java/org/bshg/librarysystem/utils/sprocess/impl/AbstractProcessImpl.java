package org.bshg.librarysystem.utils.sprocess.impl;

import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.utils.service.IService;

public abstract class AbstractProcessImpl<T extends AuditEntity, S extends IService<T>> {
    protected S service;
    protected Class<T> itemClass;

    protected AbstractProcessImpl(S service) {
        this.service = service;
    }
}
