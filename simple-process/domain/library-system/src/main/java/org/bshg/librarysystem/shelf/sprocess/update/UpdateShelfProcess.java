package org.bshg.librarysystem.shelf.sprocess.update;

import org.bshg.librarysystem.shelf.Shelf;

import java.util.List;

public interface UpdateShelfProcess {
    Shelf run(Shelf item);

    List<Shelf> run(List<Shelf> items);
}
