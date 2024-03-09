package org.bshg.librarysystem.services.facade.content;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Magazine;
import java.util.List;
public interface PublisherService {
Publisher findById(Long id);
List<Publisher> findAllOptimized();
List<Publisher> findAll();
Publisher create(Publisher item);
Publisher edit(Publisher item);
void deleteById(Long id);
void delete(Publisher item);
void delete(List<Publisher> items);
void deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Publisher findByAddressId(Long id);
}