package org.bshg.librarysystem.services.storage.shelf;

import org.bshg.librarysystem.entity.core.storage.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf findById(Long id);

    List<Shelf> findAllOptimized();

    List<Shelf> findAll();

    Shelf create(Shelf item);

    List<Shelf> create(List<Shelf> item);

    Shelf update(Shelf item);

    List<Shelf> update(List<Shelf> item);

    void deleteById(Long id);

    void delete(Shelf item);

    void delete(List<Shelf> items);

    void deleteByIdIn(List<Long> ids);
}