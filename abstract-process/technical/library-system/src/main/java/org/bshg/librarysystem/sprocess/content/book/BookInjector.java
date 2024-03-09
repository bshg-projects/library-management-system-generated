package org.bshg.librarysystem.sprocess.content.book;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.impl.CreateBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.book.impl.UpdateBookProcessImpl;
import org.bshg.librarysystem.sprocess.content.book.impl.DeleteBookProcessImpl;
import org.bshg.librarysystem.services.facade.storage.RackService;
import org.bshg.librarysystem.sprocess.storage.rack.facade.CreateRackProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.UpdateRackProcess;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.UpdateBookGenreProcess;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.UpdateEmployeeProcess;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.UpdateAuthorBookProcess;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.facade.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.DeleteAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.DeleteRackProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
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