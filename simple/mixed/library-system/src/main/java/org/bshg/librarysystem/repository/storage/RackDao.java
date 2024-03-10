package org.bshg.librarysystem.repository.storage;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RackDao extends JpaRepository<Rack, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByShelfId(Long id);

    List<Rack> findByShelfId(Long id);
}