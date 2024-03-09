package org.bshg.librarysystem.sprocess.content.publisher.impl;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.facade.UpdatePublisherProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.sprocess.content.magazine.facade.UpdateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.DeleteMagazineProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdatePublisherProcessImpl implements UpdatePublisherProcess {
@Transactional(rollbackFor = Exception.class)
public Publisher run(Publisher item) { // Your Logic To Update 'Publisher'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
public List<Publisher> run(List<Publisher> items) {
items.forEach(this::run);
return items;
}
public void updateAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
bookService.findByPublisherId(item.getId()),
item.getBooks(),
Book::setPublisher,
updateBookProcess::run,
deleteBookProcess::run
);
ProcessHelper.updateList(
item,
magazineService.findByPublisherId(item.getId()),
item.getMagazines(),
Magazine::setPublisher,
updateMagazineProcess::run,
deleteMagazineProcess::run
);
}
@Autowired private PublisherService service;
@Autowired BookService bookService;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired MagazineService magazineService;
@Autowired @Lazy private UpdateMagazineProcess updateMagazineProcess;
@Autowired @Lazy private DeleteMagazineProcess deleteMagazineProcess;
}