package org.bshg.librarysystem.reservation.sprocess.create;
import org.bshg.librarysystem.reservation.Reservation;
import java.util.List;
public interface CreateReservationProcess {
Reservation run(Reservation item);
List<Reservation> run(List<Reservation> items);
}