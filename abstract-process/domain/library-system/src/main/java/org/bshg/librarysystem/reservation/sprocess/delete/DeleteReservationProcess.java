package org.bshg.librarysystem.reservation.sprocess.delete;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteReservationProcess extends IDeleteProcess<Reservation> {
    void deleteByBook(Book book);

    void deleteByClient(Client client);
}