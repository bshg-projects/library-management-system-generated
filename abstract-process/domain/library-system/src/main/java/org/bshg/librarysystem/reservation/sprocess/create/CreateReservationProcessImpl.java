package org.bshg.librarysystem.reservation.sprocess.create;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.create.CreateReservationProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateReservationProcessImpl extends AbstractCreateProcessImpl<Reservation, ReservationService> implements CreateReservationProcess {
public CreateReservationProcessImpl(ReservationService service, BookService bookService, ClientService clientService) {
super(service);
this.bookService = bookService;
this.clientService = clientService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Reservation run(Reservation item) {
// Your Insert Logic For 'Reservation'
item = service.create(item);
return item;
}
private BookService bookService;
private CreateBookProcess createBookProcess;
public void setCreateBookProcess(CreateBookProcess value) {
this.createBookProcess = value;
}
private ClientService clientService;
private CreateClientProcess createClientProcess;
public void setCreateClientProcess(CreateClientProcess value) {
this.createClientProcess = value;
}
}