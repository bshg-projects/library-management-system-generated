package org.bshg.librarysystem.sprocess.content.book.update;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.sprocess.storage.rack.update.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.sprocess.content.bookgenre.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.sprocess.content.authorbook.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.sprocess.content.publisher.update.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateBookProcessImpl extends AbstractUpdateProcessImpl<Book, BookService> implements UpdateBookProcess {
public UpdateBookProcessImpl(BookService service, RackService rackService, BookGenreService bookGenreService, EmployeeService employeeService, AuthorBookService authorBookService, PublisherService publisherService) {
super(service);
this.rackService = rackService;
this.bookGenreService = bookGenreService;
this.employeeService = employeeService;
this.authorBookService = authorBookService;
this.publisherService = publisherService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Book run(Book item) {
// Your Update Logic For 'Book'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
@Override
public void updateAssociatedList(Book item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
authorBookService::findByBookId,
Book::getAuthorBook,
AuthorBook::setBook,
updateAuthorBookProcess,
deleteAuthorBookProcess
);
ProcessHelper.updateList(
item,
bookGenreService::findByBookId,
Book::getBookGenre,
BookGenre::setBook,
updateBookGenreProcess,
deleteBookGenreProcess
);
}
private RackService rackService;
private UpdateRackProcess updateRackProcess;
private DeleteRackProcess deleteRackProcess;
public void setUpdateRackProcess(UpdateRackProcess value) {
this.updateRackProcess = value;
}
public void setDeleteRackProcess(DeleteRackProcess value) {
this.deleteRackProcess = value;
}
private BookGenreService bookGenreService;
private UpdateBookGenreProcess updateBookGenreProcess;
private DeleteBookGenreProcess deleteBookGenreProcess;
public void setUpdateBookGenreProcess(UpdateBookGenreProcess value) {
this.updateBookGenreProcess = value;
}
public void setDeleteBookGenreProcess(DeleteBookGenreProcess value) {
this.deleteBookGenreProcess = value;
}
private EmployeeService employeeService;
private UpdateEmployeeProcess updateEmployeeProcess;
private DeleteEmployeeProcess deleteEmployeeProcess;
public void setUpdateEmployeeProcess(UpdateEmployeeProcess value) {
this.updateEmployeeProcess = value;
}
public void setDeleteEmployeeProcess(DeleteEmployeeProcess value) {
this.deleteEmployeeProcess = value;
}
private AuthorBookService authorBookService;
private UpdateAuthorBookProcess updateAuthorBookProcess;
private DeleteAuthorBookProcess deleteAuthorBookProcess;
public void setUpdateAuthorBookProcess(UpdateAuthorBookProcess value) {
this.updateAuthorBookProcess = value;
}
public void setDeleteAuthorBookProcess(DeleteAuthorBookProcess value) {
this.deleteAuthorBookProcess = value;
}
private PublisherService publisherService;
private UpdatePublisherProcess updatePublisherProcess;
private DeletePublisherProcess deletePublisherProcess;
public void setUpdatePublisherProcess(UpdatePublisherProcess value) {
this.updatePublisherProcess = value;
}
public void setDeletePublisherProcess(DeletePublisherProcess value) {
this.deletePublisherProcess = value;
}
}