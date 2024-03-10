package org.bshg.librarysystem.transaction.services;

import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionDao dao;

    @Override
    public Transaction findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return dao.findAll();
    }

    public List<Transaction> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Transaction create(Transaction item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Transaction edit(Transaction item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Transaction item) {
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
    public void delete(List<Transaction> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByClientId(Long id) {
        return dao.deleteByClientId(id);
    }

    @Override
    public List<Transaction> findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    @Autowired
    private ClientService clientService;
}