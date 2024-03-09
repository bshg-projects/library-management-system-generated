
package org.bshg.librarysystem.sprocess.content.publisher.delete;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.magazine.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeletePublisherProcessImpl implements DeletePublisherProcess {
private void process(Publisher item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Publisher item) {
process(item);
deleteAssociated(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Publisher item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Publisher item = service.findById(id);
if (item != null) {
process(item);
deleteAssociated(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Publisher> items) {
items.forEach(this::process);
items.forEach(this::deleteAssociated);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByAddress(Address address) {
if (address != null && address.getId() != null){
Publisher found = this.service.findByAddressId(address.getId());
if (found == null) return;
this.deleteAssociated(found);
service.deleteByAddressId(address.getId());
}
}
@Transactional(rollbackFor = Exception.class)
protected void deleteAssociated(Publisher item) {
if (item == null || item.getId() == null) return;
deleteAssociatedList(item);
}
private void deleteAssociatedList(Publisher item) {
deleteBookProcess.deleteByPublisher(item);
deleteMagazineProcess.deleteByPublisher(item);
}
@Autowired private PublisherService service;
@Autowired @Lazy private AddressService addressService;
@Autowired @Lazy private BookService bookService;
@Autowired @Lazy private MagazineService magazineService;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteMagazineProcess deleteMagazineProcess;
@Autowired @Lazy private DeleteAddressProcess deleteAddressProcess;
}