package org.bshg.librarysystem.book.sprocess.create;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.publisher.Publisher;
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