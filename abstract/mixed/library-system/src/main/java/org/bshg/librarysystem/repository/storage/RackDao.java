package org.bshg.librarysystem.repository.storage;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.utils.repository.Repository;

import java.util.List;

public interface RackDao extends Repository<Rack, Long> {
    int deleteByShelfId(Long id);

    List<Rack> findByShelfId(Long id);
}