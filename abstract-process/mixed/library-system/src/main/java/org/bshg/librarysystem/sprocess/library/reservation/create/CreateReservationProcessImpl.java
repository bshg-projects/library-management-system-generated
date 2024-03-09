package org.bshg.librarysystem.sprocess.library.reservation.create;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.create.CreateReservationProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
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