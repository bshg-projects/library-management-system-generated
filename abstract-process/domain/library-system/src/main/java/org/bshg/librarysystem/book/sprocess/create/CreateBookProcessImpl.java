package org.bshg.librarysystem.book.sprocess.create;

import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
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