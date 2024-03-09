package org.bshg.librarysystem.rack.sprocess.update;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateRackProcessImpl implements UpdateRackProcess {
@Transactional(rollbackFor = Exception.class)
public Rack run(Rack item) { // Your Logic To Update 'Rack'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
public List<Rack> run(List<Rack> items) {
items.forEach(this::run);
return items;
}
public void updateAssociatedList(Rack item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
bookService.findByRackId(item.getId()),
item.getBooks(),
Book::setRack,
updateBookProcess::run,
deleteBookProcess::run
);
}
@Autowired private RackService service;
@Autowired BookService bookService;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
}