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
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateBookProcessImpl implements CreateBookProcess {
@Transactional(rollbackFor = Exception.class)
public Book run(Book item) {
// Your Creation Logic For 'Book'
item = service.create(item);
createAssociatedList(item);
return item;
}
public List<Book> run(List<Book> items) {
items.forEach(this::run);
return items;
}
public void createAssociatedList(Book item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Book::getAuthorBook, AuthorBook::setBook, createAuthorBookProcess::run);
ProcessHelper.createList(item, Book::getBookGenre, BookGenre::setBook, createBookGenreProcess::run);
}
@Autowired private BookService service;
@Autowired private RackService rackService;
@Autowired @Lazy private CreateRackProcess createRackProcess;
@Autowired private BookGenreService bookGenreService;
@Autowired @Lazy private CreateBookGenreProcess createBookGenreProcess;
@Autowired private EmployeeService employeeService;
@Autowired @Lazy private CreateEmployeeProcess createEmployeeProcess;
@Autowired private AuthorBookService authorBookService;
@Autowired @Lazy private CreateAuthorBookProcess createAuthorBookProcess;
@Autowired private PublisherService publisherService;
@Autowired @Lazy private CreatePublisherProcess createPublisherProcess;
}