package org.bshg.librarysystem.reservation.services;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import java.util.List;
public interface ReservationService {
Reservation findById(Long id);
List<Reservation> findAllOptimized();
List<Reservation> findAll();
Reservation create(Reservation item);
Reservation edit(Reservation item);
void deleteById(Long id);
void delete(Reservation item);
void delete(List<Reservation> items);
void deleteByIdIn(List<Long> ids);
int deleteByBookId(Long id);
Reservation findByBookId(Long id);
int deleteByClientId(Long id);
List<Reservation> findByClientId(Long id);
}