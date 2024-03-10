package org.bshg.librarysystem.repository.storage;

import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelfDao extends JpaRepository<Shelf, Long> {
    int deleteByIdIn(List<Long> ids);
}