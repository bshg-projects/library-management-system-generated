package org.bshg.librarysystem.sprocess.library.reservation.create;

import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ReservationService service;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    private ClientService clientService;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
}