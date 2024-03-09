package org.bshg.librarysystem.publisher.sprocess.update;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
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