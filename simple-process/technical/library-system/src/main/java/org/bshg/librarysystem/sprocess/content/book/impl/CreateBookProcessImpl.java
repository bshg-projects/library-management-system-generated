package org.bshg.librarysystem.sprocess.content.book.impl;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.CreateRackProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private BookService service;
    @Autowired
    private RackService rackService;
    @Autowired
    @Lazy
    private CreateRackProcess createRackProcess;
    @Autowired
    private BookGenreService bookGenreService;
    @Autowired
    @Lazy
    private CreateBookGenreProcess createBookGenreProcess;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    @Lazy
    private CreateEmployeeProcess createEmployeeProcess;
    @Autowired
    private AuthorBookService authorBookService;
    @Autowired
    @Lazy
    private CreateAuthorBookProcess createAuthorBookProcess;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    @Lazy
    private CreatePublisherProcess createPublisherProcess;
}