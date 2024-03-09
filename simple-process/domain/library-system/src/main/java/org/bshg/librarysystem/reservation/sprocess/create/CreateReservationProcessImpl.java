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
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateReservationProcessImpl implements CreateReservationProcess {
@Transactional(rollbackFor = Exception.class)
public Reservation run(Reservation item) {
// Your Creation Logic For 'Reservation'
item = service.create(item);
return item;
}
public List<Reservation> run(List<Reservation> items) {
items.forEach(this::run);
return items;
}
@Autowired private ReservationService service;
@Autowired private BookService bookService;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired private ClientService clientService;
@Autowired @Lazy private CreateClientProcess createClientProcess;
}