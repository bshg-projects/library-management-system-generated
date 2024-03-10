package org.bshg.librarysystem.rack.sprocess.delete;

import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.shelf.Shelf;

import java.util.List;

public interface DeleteRackProcess {
    void run(Rack item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Rack> items);

    void deleteByShelf(Shelf shelf);
}