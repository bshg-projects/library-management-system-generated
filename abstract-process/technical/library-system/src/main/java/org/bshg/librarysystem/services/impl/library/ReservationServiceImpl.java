package org.bshg.librarysystem.services.impl.library;

import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.repository.library.ReservationDao;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.services.facade.user.ClientService;
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