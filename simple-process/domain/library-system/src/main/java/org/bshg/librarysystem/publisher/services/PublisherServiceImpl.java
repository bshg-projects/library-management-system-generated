package org.bshg.librarysystem.publisher.services;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.PublisherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherDao dao;

    @Override
    public Publisher findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Publisher> findAll() {
        return dao.findAll();
    }

    public List<Publisher> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Publisher create(Publisher item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Publisher edit(Publisher item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Publisher item) {
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
    public void delete(List<Publisher> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAddressId(Long id) {
        return dao.deleteByAddressId(id);
    }

    @Override
    public Publisher findByAddressId(Long id) {
        return dao.findByAddressId(id);
    }

    @Autowired
    private AddressService addressService;
}