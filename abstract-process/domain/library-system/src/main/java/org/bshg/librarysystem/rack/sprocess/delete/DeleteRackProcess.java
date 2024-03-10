package org.bshg.librarysystem.rack.sprocess.delete;

import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteRackProcess extends IDeleteProcess<Rack> {
    void deleteByShelf(Shelf shelf);
}