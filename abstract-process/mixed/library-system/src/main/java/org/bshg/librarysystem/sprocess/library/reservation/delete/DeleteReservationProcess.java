package org.bshg.librarysystem.sprocess.library.reservation.delete;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
public interface DeleteReservationProcess extends IDeleteProcess<Reservation> {
void deleteByBook(Book book);
void deleteByClient(Client client);
}