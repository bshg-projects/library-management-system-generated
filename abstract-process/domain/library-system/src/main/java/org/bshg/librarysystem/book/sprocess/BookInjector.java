package org.bshg.librarysystem.book.sprocess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcessImpl;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcessImpl;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcessImpl;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcess;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.authorbook.sprocess.create.CreateAuthorBookProcess;
import org.bshg.librarysystem.authorbook.sprocess.update.UpdateAuthorBookProcess;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Book Processes (Create, Update, Delete).
*/
@Configuration
public class BookInjector {
@Bean
public CreateBookProcess createBookProcess (BookService service,RackService rackService,BookGenreService bookGenreService,EmployeeService employeeService,AuthorBookService authorBookService,PublisherService publisherService) {
var bean = new CreateBookProcessImpl(service, rackService, bookGenreService, employeeService, authorBookService, publisherService);
bean.setCreateRackProcess(this.createRackProcess);
bean.setCreateBookGenreProcess(this.createBookGenreProcess);
bean.setCreateEmployeeProcess(this.createEmployeeProcess);
bean.setCreateAuthorBookProcess(this.createAuthorBookProcess);
bean.setCreatePublisherProcess(this.createPublisherProcess);
return bean;
}
@Bean
public UpdateBookProcess updateBookProcess (BookService service,RackService rackService,BookGenreService bookGenreService,EmployeeService employeeService,AuthorBookService authorBookService,PublisherService publisherService) {
var bean = new UpdateBookProcessImpl(service,rackService,bookGenreService,employeeService,authorBookService,publisherService);
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
public DeleteBookProcess deleteBookProcess(BookService service,RackService rackService,BookGenreService bookGenreService,EmployeeService employeeService,AuthorBookService authorBookService,PublisherService publisherService) {
var bean = new DeleteBookProcessImpl(service,rackService,bookGenreService,employeeService,authorBookService,publisherService);
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
@Autowired @Lazy private CreateRackProcess createRackProcess;
@Autowired @Lazy private UpdateRackProcess updateRackProcess;
@Autowired @Lazy private CreateBookGenreProcess createBookGenreProcess;
@Autowired @Lazy private UpdateBookGenreProcess updateBookGenreProcess;
@Autowired @Lazy private CreateEmployeeProcess createEmployeeProcess;
@Autowired @Lazy private UpdateEmployeeProcess updateEmployeeProcess;
@Autowired @Lazy private CreateAuthorBookProcess createAuthorBookProcess;
@Autowired @Lazy private UpdateAuthorBookProcess updateAuthorBookProcess;
@Autowired @Lazy private CreatePublisherProcess createPublisherProcess;
@Autowired @Lazy private UpdatePublisherProcess updatePublisherProcess;
@Autowired @Lazy private DeleteAuthorBookProcess deleteAuthorBookProcess;
@Autowired @Lazy private DeleteBookGenreProcess deleteBookGenreProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
@Autowired @Lazy private DeletePublisherProcess deletePublisherProcess;
@Autowired @Lazy private DeleteRackProcess deleteRackProcess;
@Autowired @Lazy private DeleteLoanProcess deleteLoanProcess;
@Autowired @Lazy private DeleteReservationProcess deleteReservationProcess;
@Autowired @Lazy private DeleteReviewProcess deleteReviewProcess;
}