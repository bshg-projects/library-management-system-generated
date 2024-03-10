package org.bshg.librarysystem.sprocess.content.book.delete;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

import java.util.List;

public class DeleteBookProcessImpl extends AbstractDeleteProcessImpl<Book, BookService> implements DeleteBookProcess {
    public DeleteBookProcessImpl(BookService service, RackService rackService, BookGenreService bookGenreService, EmployeeService employeeService, AuthorBookService authorBookService, PublisherService publisherService) {
        super(service);
        this.rackService = rackService;
        this.bookGenreService = bookGenreService;
        this.employeeService = employeeService;
        this.authorBookService = authorBookService;
        this.publisherService = publisherService;
    }

    @Override
    protected void process(Book item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByEmployee(Employee employee) {
        if (employee != null && employee.getId() != null) {
            List<Book> found = this.service.findByEmployeeId(employee.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociated);
            service.deleteByEmployeeId(employee.getId());
        }
    }

    public void deleteByPublisher(Publisher publisher) {
        if (publisher != null && publisher.getId() != null) {
            List<Book> found = this.service.findByPublisherId(publisher.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociated);
            service.deleteByPublisherId(publisher.getId());
        }
    }

    public void deleteByRack(Rack rack) {
        if (rack != null && rack.getId() != null) {
            List<Book> found = this.service.findByRackId(rack.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociated);
            service.deleteByRackId(rack.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Book item) {
        deleteAuthorBookProcess.deleteByBook(item);
        deleteBookGenreProcess.deleteByBook(item);
    }

    @Override
    public void deleteAssociatedObjects(Book item) {
        deleteLoanProcess.deleteByBook(item);
        deleteReservationProcess.deleteByBook(item);
        deleteReviewProcess.deleteByBook(item);
    }

    private RackService rackService;
    private BookGenreService bookGenreService;
    private EmployeeService employeeService;
    private AuthorBookService authorBookService;
    private PublisherService publisherService;
    private DeleteAuthorBookProcess deleteAuthorBookProcess;

    public void setDeleteAuthorBookProcess(DeleteAuthorBookProcess value) {
        this.deleteAuthorBookProcess = value;
    }

    private DeleteBookGenreProcess deleteBookGenreProcess;

    public void setDeleteBookGenreProcess(DeleteBookGenreProcess value) {
        this.deleteBookGenreProcess = value;
    }

    private DeleteEmployeeProcess deleteEmployeeProcess;

    public void setDeleteEmployeeProcess(DeleteEmployeeProcess value) {
        this.deleteEmployeeProcess = value;
    }

    private DeletePublisherProcess deletePublisherProcess;

    public void setDeletePublisherProcess(DeletePublisherProcess value) {
        this.deletePublisherProcess = value;
    }

    private DeleteRackProcess deleteRackProcess;

    public void setDeleteRackProcess(DeleteRackProcess value) {
        this.deleteRackProcess = value;
    }

    private DeleteLoanProcess deleteLoanProcess;

    public void setDeleteLoanProcess(DeleteLoanProcess value) {
        this.deleteLoanProcess = value;
    }

    private DeleteReservationProcess deleteReservationProcess;

    public void setDeleteReservationProcess(DeleteReservationProcess value) {
        this.deleteReservationProcess = value;
    }

    private DeleteReviewProcess deleteReviewProcess;

    public void setDeleteReviewProcess(DeleteReviewProcess value) {
        this.deleteReviewProcess = value;
    }
}