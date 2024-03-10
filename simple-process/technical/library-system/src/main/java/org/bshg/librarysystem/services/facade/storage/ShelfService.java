package org.bshg.librarysystem.services.facade.storage;

import org.bshg.librarysystem.entity.core.storage.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf findById(Long id);

    List<Shelf> findAllOptimized();

    List<Shelf> findAll();

    Shelf create(Shelf item);

    Shelf edit(Shelf item);

    void deleteById(Long id);

    void delete(Shelf item);

    void delete(List<Shelf> items);

    void deleteByIdIn(List<Long> ids);
}