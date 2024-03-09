package org.bshg.librarysystem.sprocess.library.reservation.delete;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import java.util.List;
public interface DeleteReservationProcess {
void run(Reservation item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Reservation> items);
void deleteByBook(Book book);
void deleteByClient(Client client);
}