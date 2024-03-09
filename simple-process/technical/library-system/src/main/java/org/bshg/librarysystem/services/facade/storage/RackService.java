package org.bshg.librarysystem.services.facade.storage;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import java.util.List;
public interface RackService {
Rack findById(Long id);
List<Rack> findAllOptimized();
List<Rack> findAll();
Rack create(Rack item);
Rack edit(Rack item);
void deleteById(Long id);
void delete(Rack item);
void delete(List<Rack> items);
void deleteByIdIn(List<Long> ids);
int deleteByShelfId(Long id);
List<Rack> findByShelfId(Long id);
}