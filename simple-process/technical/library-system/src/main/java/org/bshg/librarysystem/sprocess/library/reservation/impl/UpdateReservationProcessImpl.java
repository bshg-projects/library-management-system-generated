package org.bshg.librarysystem.sprocess.library.reservation.impl;

import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.facade.UpdateReservationProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateReservationProcessImpl implements UpdateReservationProcess {
    @Transactional(rollbackFor = Exception.class)
    public Reservation run(Reservation item) { // Your Logic To Update 'Reservation'
        item = service.edit(item);
        return item;
    }

    public List<Reservation> run(List<Reservation> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private ReservationService service;
}