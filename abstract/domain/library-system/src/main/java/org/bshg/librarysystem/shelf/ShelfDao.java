package org.bshg.librarysystem.shelf;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ShelfDao extends Repository<Shelf, Long> {
}