package org.bshg.librarysystem.shelf.sprocess.delete;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.rack.Rack;
import java.util.List;
public interface DeleteShelfProcess {
void run(Shelf item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Shelf> items);
}