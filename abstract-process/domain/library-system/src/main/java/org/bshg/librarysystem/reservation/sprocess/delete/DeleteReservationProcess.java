package org.bshg.librarysystem.reservation.sprocess.delete;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
public interface DeleteReservationProcess extends IDeleteProcess<Reservation> {
void deleteByBook(Book book);
void deleteByClient(Client client);
}