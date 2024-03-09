package org.bshg.librarysystem.sprocess.storage.shelf.facade;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import java.util.List;
public interface CreateShelfProcess {
Shelf run(Shelf item);
List<Shelf> run(List<Shelf> items);
}