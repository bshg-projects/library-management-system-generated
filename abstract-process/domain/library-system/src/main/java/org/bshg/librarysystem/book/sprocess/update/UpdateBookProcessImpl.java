package org.bshg.librarysystem.book.sprocess.update;

import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcess;
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