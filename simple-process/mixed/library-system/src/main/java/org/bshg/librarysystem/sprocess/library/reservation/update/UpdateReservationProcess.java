package org.bshg.librarysystem.sprocess.library.reservation.update;

import org.bshg.librarysystem.entity.core.library.Reservation;

import java.util.List;

public interface UpdateReservationProcess {
    Reservation run(Reservation item);

    List<Reservation> run(List<Reservation> items);
}
