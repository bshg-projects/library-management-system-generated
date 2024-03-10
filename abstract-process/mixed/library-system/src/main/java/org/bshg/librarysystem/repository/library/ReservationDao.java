package org.bshg.librarysystem.repository.library;

import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationDao extends Repository<Reservation, Long> {
    int deleteByBookId(Long id);

    Reservation findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Reservation> findByClientId(Long id);

    @Query("SELECT NEW Reservation(item.id,item.name) FROM Reservation item")
    List<Reservation> findAllOptimized();
}