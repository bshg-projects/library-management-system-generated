
package org.bshg.librarysystem.book.sprocess.delete;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.authorbook.sprocess.delete.DeleteAuthorBookProcess;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
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
if (employee != null && employee.getId() != null){
List<Book> found = this.service.findByEmployeeId(employee.getId());
if (found == null) return;
found.forEach(this::deleteAssociated);
service.deleteByEmployeeId(employee.getId());
}
}
public void deleteByPublisher(Publisher publisher) {
if (publisher != null && publisher.getId() != null){
List<Book> found = this.service.findByPublisherId(publisher.getId());
if (found == null) return;
found.forEach(this::deleteAssociated);
service.deleteByPublisherId(publisher.getId());
}
}
public void deleteByRack(Rack rack) {
if (rack != null && rack.getId() != null){
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