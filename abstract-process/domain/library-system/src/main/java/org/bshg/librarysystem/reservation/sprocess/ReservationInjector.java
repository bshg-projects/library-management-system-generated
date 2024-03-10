package org.bshg.librarysystem.reservation.sprocess;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.create.CreateReservationProcess;
import org.bshg.librarysystem.reservation.sprocess.create.CreateReservationProcessImpl;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcessImpl;
import org.bshg.librarysystem.reservation.sprocess.update.UpdateReservationProcess;
import org.bshg.librarysystem.reservation.sprocess.update.UpdateReservationProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Reservation Processes (Create, Update, Delete).
 */
@Configuration
public class ReservationInjector {
    @Bean
    public CreateReservationProcess createReservationProcess(ReservationService service, BookService bookService, ClientService clientService) {
        var bean = new CreateReservationProcessImpl(service, bookService, clientService);
        bean.setCreateBookProcess(this.createBookProcess);
        bean.setCreateClientProcess(this.createClientProcess);
        return bean;
    }

    @Bean
    public UpdateReservationProcess updateReservationProcess(ReservationService service, BookService bookService, ClientService clientService) {
        var bean = new UpdateReservationProcessImpl(service, bookService, clientService);
        bean.setUpdateBookProcess(this.updateBookProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setUpdateClientProcess(this.updateClientProcess);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Bean
    public DeleteReservationProcess deleteReservationProcess(ReservationService service, BookService bookService, ClientService clientService) {
        var bean = new DeleteReservationProcessImpl(service, bookService, clientService);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    @Lazy
    private UpdateBookProcess updateBookProcess;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
    @Autowired
    @Lazy
    private UpdateClientProcess updateClientProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteClientProcess deleteClientProcess;
}