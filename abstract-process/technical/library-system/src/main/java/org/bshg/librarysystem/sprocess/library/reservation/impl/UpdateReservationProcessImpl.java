package org.bshg.librarysystem.sprocess.library.reservation.impl;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.facade.UpdateReservationProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
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