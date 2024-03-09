package org.bshg.librarysystem.sprocess.content.publisher.create;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcess;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.create.CreateMagazineProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreatePublisherProcessImpl implements CreatePublisherProcess {
@Transactional(rollbackFor = Exception.class)
public Publisher run(Publisher item) {
// Your Creation Logic For 'Publisher'
item = service.create(item);
createAssociatedList(item);
return item;
}
public List<Publisher> run(List<Publisher> items) {
items.forEach(this::run);
return items;
}
public void createAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Publisher::getBooks, Book::setPublisher, createBookProcess::run);
ProcessHelper.createList(item, Publisher::getMagazines, Magazine::setPublisher, createMagazineProcess::run);
}
@Autowired private PublisherService service;
@Autowired private AddressService addressService;
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
@Autowired private BookService bookService;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired private MagazineService magazineService;
@Autowired @Lazy private CreateMagazineProcess createMagazineProcess;
}