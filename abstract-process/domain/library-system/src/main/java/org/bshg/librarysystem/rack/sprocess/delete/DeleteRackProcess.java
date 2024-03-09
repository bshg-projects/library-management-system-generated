package org.bshg.librarysystem.rack.sprocess.delete;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.shelf.Shelf;
public interface DeleteRackProcess extends IDeleteProcess<Rack> {
void deleteByShelf(Shelf shelf);
}