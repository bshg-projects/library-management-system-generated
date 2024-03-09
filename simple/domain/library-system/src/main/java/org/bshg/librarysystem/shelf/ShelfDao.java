package org.bshg.librarysystem.shelf;
import org.bshg.librarysystem.shelf.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ShelfDao extends JpaRepository<Shelf, Long> {
int deleteByIdIn(List<Long> ids);
}