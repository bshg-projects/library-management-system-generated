package org.bshg.librarysystem.reservation;
import org.bshg.librarysystem.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ReservationDao extends JpaRepository<Reservation, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByBookId(Long id);
Reservation findByBookId(Long id);
int deleteByClientId(Long id);
List<Reservation> findByClientId(Long id);
@Query("SELECT NEW Reservation(item.id,item.name) FROM Reservation item")
List<Reservation> findAllOptimized();
}