package org.bshg.librarysystem.reservation.sprocess.delete;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import java.util.List;
public interface DeleteReservationProcess {
void run(Reservation item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Reservation> items);
void deleteByBook(Book book);
void deleteByClient(Client client);
}