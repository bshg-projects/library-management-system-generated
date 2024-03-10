package org.bshg.librarysystem.sprocess.storage.shelf.update;

import org.bshg.librarysystem.entity.core.storage.Shelf;

import java.util.List;

public interface UpdateShelfProcess {
    Shelf run(Shelf item);

    List<Shelf> run(List<Shelf> items);
}
