package org.bshg.librarysystem.sprocess.library.reservation.impl;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.facade.CreateReservationProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
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