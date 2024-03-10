package org.bshg.librarysystem.sprocess.library.reservation.delete;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteReservationProcess extends IDeleteProcess<Reservation> {
    void deleteByBook(Book book);

    void deleteByClient(Client client);
}