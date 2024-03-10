package org.bshg.librarysystem.services.facade.storage;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface RackService extends IService<Rack> {
    int deleteByShelfId(Long id);

    List<Rack> findByShelfId(Long id);
}