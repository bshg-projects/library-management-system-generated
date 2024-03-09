package org.bshg.librarysystem.shelf.sprocess.create;
import org.bshg.librarysystem.shelf.Shelf;
import java.util.List;
public interface CreateShelfProcess {
Shelf run(Shelf item);
List<Shelf> run(List<Shelf> items);
}