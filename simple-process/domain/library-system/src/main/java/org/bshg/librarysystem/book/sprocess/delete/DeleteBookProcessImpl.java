
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteBookProcessImpl implements DeleteBookProcess {
private void process(Book item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Book item) {
process(item);
deleteAssociated(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Book item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Book item = service.findById(id);
if (item != null) {
process(item);
deleteAssociated(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Book> items) {
items.forEach(this::process);
items.forEach(this::deleteAssociated);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByEmployee(Employee employee) {
if (employee != null && employee.getId() != null){
List<Book> found = this.service.findByEmployeeId(employee.getId());
if (found == null) return;
found.forEach(this::deleteAssociated);
service.deleteByEmployeeId(employee.getId());
}
}
@Transactional(rollbackFor = Exception.class)
public void deleteByPublisher(Publisher publisher) {
if (publisher != null && publisher.getId() != null){
List<Book> found = this.service.findByPublisherId(publisher.getId());
if (found == null) return;
found.forEach(this::deleteAssociated);
service.deleteByPublisherId(publisher.getId());
}
}
@Transactional(rollbackFor = Exception.class)
public void deleteByRack(Rack rack) {
if (rack != null && rack.getId() != null){
List<Book> found = this.service.findByRackId(rack.getId());
if (found == null) return;
found.forEach(this::deleteAssociated);
service.deleteByRackId(rack.getId());
}
}
@Transactional(rollbackFor = Exception.class)
protected void deleteAssociated(Book item) {
if (item == null || item.getId() == null) return;
deleteAssociatedList(item);
deleteAssociatedObjects(item);
}
private void deleteAssociatedList(Book item) {
deleteAuthorBookProcess.deleteByBook(item);
deleteBookGenreProcess.deleteByBook(item);
}
private void deleteAssociatedObjects(Book item) {
deleteLoanProcess.deleteByBook(item);
deleteReservationProcess.deleteByBook(item);
deleteReviewProcess.deleteByBook(item);
}
@Autowired private BookService service;
@Autowired @Lazy private RackService rackService;
@Autowired @Lazy private BookGenreService bookGenreService;
@Autowired @Lazy private EmployeeService employeeService;
@Autowired @Lazy private AuthorBookService authorBookService;
@Autowired @Lazy private PublisherService publisherService;
@Autowired @Lazy private DeleteAuthorBookProcess deleteAuthorBookProcess;
@Autowired @Lazy private DeleteBookGenreProcess deleteBookGenreProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
@Autowired @Lazy private DeletePublisherProcess deletePublisherProcess;
@Autowired @Lazy private DeleteRackProcess deleteRackProcess;
@Autowired @Lazy private DeleteLoanProcess deleteLoanProcess;
@Autowired @Lazy private DeleteReservationProcess deleteReservationProcess;
@Autowired @Lazy private DeleteReviewProcess deleteReviewProcess;
}