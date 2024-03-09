package org.bshg.librarysystem.sprocess.content.publisher.impl;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.facade.CreatePublisherProcess;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
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