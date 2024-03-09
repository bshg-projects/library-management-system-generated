
package org.bshg.librarysystem.publisher.services;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.PublisherDao;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class PublisherServiceImpl extends ServiceImpl<Publisher, PublisherDao> implements PublisherService {
public PublisherServiceImpl(PublisherDao dao) {
super(dao);
}
@Override
public List<Publisher> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
public void deleteAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
bookService.deleteByPublisherId(item.getId());
magazineService.deleteByPublisherId(item.getId());
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAddressId(Long id){
Publisher found = findByAddressId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByAddressId(id);
}
@Override
public Publisher findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Override
public void createAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Publisher::getBooks, Book::setPublisher, bookService);
ServiceHelper.createList(item, Publisher::getMagazines, Magazine::setPublisher, magazineService);
}
@Override
public void updateAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,bookService::findByPublisherId,Publisher::getBooks,Book::setPublisher,bookService);
ServiceHelper.updateList(item,magazineService::findByPublisherId,Publisher::getMagazines,Magazine::setPublisher,magazineService);
}
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private MagazineService magazineService;
@Lazy @Autowired private AddressService addressService;
}