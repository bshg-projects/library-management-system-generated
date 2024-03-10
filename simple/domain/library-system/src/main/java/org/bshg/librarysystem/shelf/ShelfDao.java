package org.bshg.librarysystem.shelf;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelfDao extends JpaRepository<Shelf, Long> {
    int deleteByIdIn(List<Long> ids);
}