package org.bshg.librarysystem.sprocess.library.reservation.update;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.update.UpdateReservationProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateReservationProcessImpl extends AbstractUpdateProcessImpl<Reservation, ReservationService> implements UpdateReservationProcess {
public UpdateReservationProcessImpl(ReservationService service, BookService bookService, ClientService clientService) {
super(service);
this.bookService = bookService;
this.clientService = clientService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Reservation run(Reservation item) {
// Your Update Logic For 'Reservation'
item = service.edit(item);
return item;
}
private BookService bookService;
private UpdateBookProcess updateBookProcess;
private DeleteBookProcess deleteBookProcess;
public void setUpdateBookProcess(UpdateBookProcess value) {
this.updateBookProcess = value;
}
public void setDeleteBookProcess(DeleteBookProcess value) {
this.deleteBookProcess = value;
}
private ClientService clientService;
private UpdateClientProcess updateClientProcess;
private DeleteClientProcess deleteClientProcess;
public void setUpdateClientProcess(UpdateClientProcess value) {
this.updateClientProcess = value;
}
public void setDeleteClientProcess(DeleteClientProcess value) {
this.deleteClientProcess = value;
}
}