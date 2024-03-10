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
import org.bshg.librarysystem.sprocess.content.authorbook.facade.DeleteAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.UpdateEmployeeProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
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