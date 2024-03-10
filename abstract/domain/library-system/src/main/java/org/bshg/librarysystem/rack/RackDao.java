package org.bshg.librarysystem.rack;

import org.bshg.librarysystem.utils.repository.Repository;

import java.util.List;

public interface RackDao extends Repository<Rack, Long> {
    int deleteByShelfId(Long id);

    List<Rack> findByShelfId(Long id);
}