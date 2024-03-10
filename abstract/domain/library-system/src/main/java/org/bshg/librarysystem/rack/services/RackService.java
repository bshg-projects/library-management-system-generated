package org.bshg.librarysystem.rack.services;

import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface RackService extends IService<Rack> {
    int deleteByShelfId(Long id);

    List<Rack> findByShelfId(Long id);
}