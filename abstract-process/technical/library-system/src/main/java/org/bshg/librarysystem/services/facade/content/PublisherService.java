package org.bshg.librarysystem.services.facade.content;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface PublisherService extends IService<Publisher> {
int deleteByAddressId(Long id);
Publisher findByAddressId(Long id);
}