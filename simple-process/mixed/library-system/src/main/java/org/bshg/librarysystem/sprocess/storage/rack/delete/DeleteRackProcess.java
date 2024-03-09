package org.bshg.librarysystem.sprocess.storage.rack.delete;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import java.util.List;
public interface DeleteRackProcess {
void run(Rack item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Rack> items);
void deleteByShelf(Shelf shelf);
}