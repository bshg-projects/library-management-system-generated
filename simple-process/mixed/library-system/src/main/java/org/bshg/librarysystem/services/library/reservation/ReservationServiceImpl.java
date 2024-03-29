package org.bshg.librarysystem.services.library.reservation;

import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.repository.library.ReservationDao;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationDao dao;

    @Override
    public Reservation findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAll() {
        return dao.findAll();
    }

    public List<Reservation> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Reservation create(Reservation item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Reservation edit(Reservation item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Reservation item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Reservation> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
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