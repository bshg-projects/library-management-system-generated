package org.bshg.librarysystem.reservation.services;

import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface ReservationService extends IService<Reservation> {
    int deleteByBookId(Long id);

    Reservation findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Reservation> findByClientId(Long id);
}