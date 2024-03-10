package org.bshg.librarysystem.services.facade.library;

import org.bshg.librarysystem.entity.core.library.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation findById(Long id);

    List<Reservation> findAllOptimized();

    List<Reservation> findAll();

    Reservation create(Reservation item);

    List<Reservation> create(List<Reservation> item);

    Reservation update(Reservation item);

    List<Reservation> update(List<Reservation> item);

    void deleteById(Long id);

    void delete(Reservation item);

    void delete(List<Reservation> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByBookId(Long id);

    Reservation findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Reservation> findByClientId(Long id);
}