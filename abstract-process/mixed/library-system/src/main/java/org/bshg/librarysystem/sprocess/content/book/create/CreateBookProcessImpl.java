package org.bshg.librarysystem.sprocess.content.book.create;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.sprocess.storage.rack.create.CreateRackProcess;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.create.CreateBookGenreProcess;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcess;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateBookProcessImpl extends AbstractCreateProcessImpl<Book, BookService> implements CreateBookProcess {
public CreateBookProcessImpl(BookService service, RackService rackService, BookGenreService bookGenreService, EmployeeService employeeService, AuthorBookService authorBookService, PublisherService publisherService) {
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
// Your Insert Logic For 'Book'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Book item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Book::getAuthorBook, AuthorBook::setBook, createAuthorBookProcess);
ProcessHelper.createList(item, Book::getBookGenre, BookGenre::setBook, createBookGenreProcess);
}
private RackService rackService;
private CreateRackProcess createRackProcess;
public void setCreateRackProcess(CreateRackProcess value) {
this.createRackProcess = value;
}
private BookGenreService bookGenreService;
private CreateBookGenreProcess createBookGenreProcess;
public void setCreateBookGenreProcess(CreateBookGenreProcess value) {
this.createBookGenreProcess = value;
}
private EmployeeService employeeService;
private CreateEmployeeProcess createEmployeeProcess;
public void setCreateEmployeeProcess(CreateEmployeeProcess value) {
this.createEmployeeProcess = value;
}
private AuthorBookService authorBookService;
private CreateAuthorBookProcess createAuthorBookProcess;
public void setCreateAuthorBookProcess(CreateAuthorBookProcess value) {
this.createAuthorBookProcess = value;
}
private PublisherService publisherService;
private CreatePublisherProcess createPublisherProcess;
public void setCreatePublisherProcess(CreatePublisherProcess value) {
this.createPublisherProcess = value;
}
}