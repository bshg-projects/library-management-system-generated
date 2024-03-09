package org.bshg.librarysystem.rack;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface RackDao extends Repository<Rack, Long> {
int deleteByShelfId(Long id);
List<Rack> findByShelfId(Long id);
}