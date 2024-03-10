package org.bshg.librarysystem.reservation.sprocess.delete;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class DeleteReservationProcessImpl extends AbstractDeleteProcessImpl<Reservation, ReservationService> implements DeleteReservationProcess {
    public DeleteReservationProcessImpl(ReservationService service, BookService bookService, ClientService clientService) {
        super(service);
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @Override
    protected void process(Reservation item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByBook(Book book) {
        if (book != null && book.getId() != null) {
            service.deleteByBookId(book.getId());
        }
    }

    public void deleteByClient(Client client) {
        if (client != null && client.getId() != null) {
            service.deleteByClientId(client.getId());
        }
    }

    private BookService bookService;
    private ClientService clientService;
    private DeleteBookProcess deleteBookProcess;

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private DeleteClientProcess deleteClientProcess;

    public void setDeleteClientProcess(DeleteClientProcess value) {
        this.deleteClientProcess = value;
    }
}