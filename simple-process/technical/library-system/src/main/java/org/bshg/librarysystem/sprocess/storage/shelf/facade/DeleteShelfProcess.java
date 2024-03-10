package org.bshg.librarysystem.sprocess.storage.shelf.facade;

import org.bshg.librarysystem.entity.core.storage.Shelf;

import java.util.List;

public interface DeleteShelfProcess {
    void run(Shelf item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Shelf> items);
}