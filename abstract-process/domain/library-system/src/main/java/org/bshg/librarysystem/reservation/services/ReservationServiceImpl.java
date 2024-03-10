package org.bshg.librarysystem.reservation.services;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.ReservationDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl extends ServiceImpl<Reservation, ReservationDao> implements ReservationService {
    public ReservationServiceImpl(ReservationDao dao) {
        super(dao);
    }

    @Override
    public List<Reservation> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByBookId(Long id) {
        return dao.deleteByBookId(id);
    }

    @Override
    public Reservation findByBookId(Long id) {
        return dao.findByBookId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByClientId(Long id) {
        return dao.deleteByClientId(id);
    }

    @Override
    public List<Reservation> findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    @Autowired
    private BookService bookService;
    @Autowired
    private ClientService clientService;
}