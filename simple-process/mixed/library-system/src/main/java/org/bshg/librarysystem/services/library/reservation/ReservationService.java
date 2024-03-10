package org.bshg.librarysystem.services.library.reservation;

import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;

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