package org.bshg.librarysystem.sprocess.storage.rack.facade;

import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteRackProcess extends IDeleteProcess<Rack> {
    void deleteByShelf(Shelf shelf);
}