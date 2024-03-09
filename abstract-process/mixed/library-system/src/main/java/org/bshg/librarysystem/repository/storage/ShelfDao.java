package org.bshg.librarysystem.repository.storage;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ShelfDao extends Repository<Shelf, Long> {
}