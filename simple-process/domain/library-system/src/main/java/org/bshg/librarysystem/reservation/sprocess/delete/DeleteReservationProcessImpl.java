
package org.bshg.librarysystem.reservation.sprocess.delete;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteReservationProcessImpl implements DeleteReservationProcess {
private void process(Reservation item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Reservation item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Reservation item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Reservation item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Reservation> items) {
items.forEach(this::process);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByBook(Book book) {
if (book != null && book.getId() != null){
service.deleteByBookId(book.getId());
}
}
@Transactional(rollbackFor = Exception.class)
public void deleteByClient(Client client) {
if (client != null && client.getId() != null){
service.deleteByClientId(client.getId());
}
}
@Autowired private ReservationService service;
@Autowired @Lazy private BookService bookService;
@Autowired @Lazy private ClientService clientService;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
}