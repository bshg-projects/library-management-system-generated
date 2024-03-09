package org.bshg.librarysystem.sprocess.library.reservation;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.facade.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.UpdateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.impl.CreateReservationProcessImpl;
import org.bshg.librarysystem.sprocess.library.reservation.impl.UpdateReservationProcessImpl;
import org.bshg.librarysystem.sprocess.library.reservation.impl.DeleteReservationProcessImpl;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Reservation Processes (Create, Update, Delete).
*/
@Configuration
public class ReservationInjector {
@Bean
public CreateReservationProcess createReservationProcess (ReservationService service,BookService bookService,ClientService clientService) {
var bean = new CreateReservationProcessImpl(service, bookService, clientService);
bean.setCreateBookProcess(this.createBookProcess);
bean.setCreateClientProcess(this.createClientProcess);
return bean;
}
@Bean
public UpdateReservationProcess updateReservationProcess (ReservationService service,BookService bookService,ClientService clientService) {
var bean = new UpdateReservationProcessImpl(service,bookService,clientService);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setUpdateClientProcess(this.updateClientProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Bean
public DeleteReservationProcess deleteReservationProcess(ReservationService service,BookService bookService,ClientService clientService) {
var bean = new DeleteReservationProcessImpl(service,bookService,clientService);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private CreateClientProcess createClientProcess;
@Autowired @Lazy private UpdateClientProcess updateClientProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
}