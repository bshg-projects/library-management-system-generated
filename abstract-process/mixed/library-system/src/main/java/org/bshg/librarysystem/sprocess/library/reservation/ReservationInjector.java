package org.bshg.librarysystem.sprocess.library.reservation;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.create.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.update.UpdateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.create.CreateReservationProcessImpl;
import org.bshg.librarysystem.sprocess.library.reservation.update.UpdateReservationProcessImpl;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcessImpl;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
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