package org.bshg.librarysystem.services.library.reservation;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface ReservationService extends IService<Reservation> {
int deleteByBookId(Long id);
Reservation findByBookId(Long id);
int deleteByClientId(Long id);
List<Reservation> findByClientId(Long id);
}