package org.bshg.librarysystem.sprocess.storage.rack.facade;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Shelf;
public interface DeleteRackProcess extends IDeleteProcess<Rack> {
void deleteByShelf(Shelf shelf);
}