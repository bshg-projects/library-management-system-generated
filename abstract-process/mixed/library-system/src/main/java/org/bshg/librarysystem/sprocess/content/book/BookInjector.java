package org.bshg.librarysystem.sprocess.content.book;

import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.content.authorbook.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.bookgenre.create.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.update.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.storage.rack.create.CreateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.delete.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.update.UpdateRackProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Book Processes (Create, Update, Delete).
 */
@Configuration
public class BookInjector {
    @Bean
    public CreateBookProcess createBookProcess(BookService service, RackService rackService, BookGenreService bookGenreService, EmployeeService employeeService, AuthorBookService authorBookService, PublisherService publisherService) {
        var bean = new CreateBookProcessImpl(service, rackService, bookGenreService, employeeService, authorBookService, publisherService);
        bean.setCreateRackProcess(this.createRackProcess);
        bean.setCreateBookGenreProcess(this.createBookGenreProcess);
        bean.setCreateEmployeeProcess(this.createEmployeeProcess);
        bean.setCreateAuthorBookProcess(this.createAuthorBookProcess);
        bean.setCreatePublisherProcess(this.createPublisherProcess);
        return bean;
    }

    @Bean
    public UpdateBookProcess updateBookProcess(BookService service, RackService rackService, BookGenreService bookGenreService, EmployeeService employeeService, AuthorBookService authorBookService, PublisherService publisherService) {
        var bean = new UpdateBookProcessImpl(service, rackService, bookGenreService, employeeService, authorBookService, publisherService);
        bean.setUpdateRackProcess(this.updateRackProcess);
        bean.setDeleteRackProcess(this.deleteRackProcess);
        bean.setUpdateBookGenreProcess(this.updateBookGenreProcess);
        bean.setDeleteBookGenreProcess(this.deleteBookGenreProcess);
        bean.setUpdateEmployeeProcess(this.updateEmployeeProcess);
        bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
        bean.setUpdateAuthorBookProcess(this.updateAuthorBookProcess);
        bean.setDeleteAuthorBookProcess(this.deleteAuthorBookProcess);
        bean.setUpdatePublisherProcess(this.updatePublisherProcess);
        bean.setDeletePublisherProcess(this.deletePublisherProcess);
        return bean;
    }

    @Bean
    public DeleteBookProcess deleteBookProcess(BookService service, RackService rackService, BookGenreService bookGenreService, EmployeeService employeeService, AuthorBookService authorBookService, PublisherService publisherService) {
        var bean = new DeleteBookProcessImpl(service, rackService, bookGenreService, employeeService, authorBookService, publisherService);
        bean.setDeleteAuthorBookProcess(this.deleteAuthorBookProcess);
        bean.setDeleteBookGenreProcess(this.deleteBookGenreProcess);
        bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
        bean.setDeletePublisherProcess(this.deletePublisherProcess);
        bean.setDeleteRackProcess(this.deleteRackProcess);
        bean.setDeleteLoanProcess(this.deleteLoanProcess);
        bean.setDeleteReservationProcess(this.deleteReservationProcess);
        bean.setDeleteReviewProcess(this.deleteReviewProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateRackProcess createRackProcess;
    @Autowired
    @Lazy
    private UpdateRackProcess updateRackProcess;
    @Autowired
    @Lazy
    private CreateBookGenreProcess createBookGenreProcess;
    @Autowired
    @Lazy
    private UpdateBookGenreProcess updateBookGenreProcess;
    @Autowired
    @Lazy
    private CreateEmployeeProcess createEmployeeProcess;
    @Autowired
    @Lazy
    private UpdateEmployeeProcess updateEmployeeProcess;
    @Autowired
    @Lazy
    private CreateAuthorBookProcess createAuthorBookProcess;
    @Autowired
    @Lazy
    private UpdateAuthorBookProcess updateAuthorBookProcess;
    @Autowired
    @Lazy
    private CreatePublisherProcess createPublisherProcess;
    @Autowired
    @Lazy
    private UpdatePublisherProcess updatePublisherProcess;
    @Autowired
    @Lazy
    private DeleteAuthorBookProcess deleteAuthorBookProcess;
    @Autowired
    @Lazy
    private DeleteBookGenreProcess deleteBookGenreProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeProcess deleteEmployeeProcess;
    @Autowired
    @Lazy
    private DeletePublisherProcess deletePublisherProcess;
    @Autowired
    @Lazy
    private DeleteRackProcess deleteRackProcess;
    @Autowired
    @Lazy
    private DeleteLoanProcess deleteLoanProcess;
    @Autowired
    @Lazy
    private DeleteReservationProcess deleteReservationProcess;
    @Autowired
    @Lazy
    private DeleteReviewProcess deleteReviewProcess;
}