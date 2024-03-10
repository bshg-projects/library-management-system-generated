package org.bshg.librarysystem.reservation.sprocess.update;

import org.bshg.librarysystem.reservation.Reservation;

import java.util.List;

public interface UpdateReservationProcess {
    Reservation run(Reservation item);

    List<Reservation> run(List<Reservation> items);
}
