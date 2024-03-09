package org.bshg.librarysystem.services.storage.rack;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface RackService extends IService<Rack> {
int deleteByShelfId(Long id);
List<Rack> findByShelfId(Long id);
}