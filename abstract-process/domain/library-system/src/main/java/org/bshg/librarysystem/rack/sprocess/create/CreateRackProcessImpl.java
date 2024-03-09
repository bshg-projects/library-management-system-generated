package org.bshg.librarysystem.rack.sprocess.create;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.shelf.services.ShelfService;
import org.bshg.librarysystem.shelf.sprocess.create.CreateShelfProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.shelf.Shelf;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateRackProcessImpl extends AbstractCreateProcessImpl<Rack, RackService> implements CreateRackProcess {
public CreateRackProcessImpl(RackService service, BookService bookService, ShelfService shelfService) {
super(service);
this.bookService = bookService;
this.shelfService = shelfService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Rack run(Rack item) {
// Your Insert Logic For 'Rack'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Rack item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Rack::getBooks, Book::setRack, createBookProcess);
}
private BookService bookService;
private CreateBookProcess createBookProcess;
public void setCreateBookProcess(CreateBookProcess value) {
this.createBookProcess = value;
}
private ShelfService shelfService;
private CreateShelfProcess createShelfProcess;
public void setCreateShelfProcess(CreateShelfProcess value) {
this.createShelfProcess = value;
}
}