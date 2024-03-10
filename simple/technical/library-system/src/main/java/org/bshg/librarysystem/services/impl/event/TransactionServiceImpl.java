package org.bshg.librarysystem.services.impl.event;

import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.repository.event.TransactionDao;
import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    //--------------- FIND -------------------------------------
    public Transaction findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Transaction> findAll() {
        return dao.findAll();
    }

    public List<Transaction> findAllOptimized() {
        return dao.findAllOptimized();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Transaction create(Transaction item) {
        if (item == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Transaction> create(List<Transaction> items) {
        List<Transaction> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Transaction update(Transaction item) {
        if (item == null || item.getId() == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Transaction> update(List<Transaction> items) {
        List<Transaction> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Transaction item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Transaction item) {
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Transaction> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByClientId(Long id) {
        if (id == null) return 0;
        return dao.deleteByClientId(id);
    }

    @Override
    public List<Transaction> findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    //----------------------------------------------------------
//----------------------------------------------------------
    @Autowired
    private TransactionDao dao;
    @Lazy
    @Autowired
    private ClientService clientService;
}