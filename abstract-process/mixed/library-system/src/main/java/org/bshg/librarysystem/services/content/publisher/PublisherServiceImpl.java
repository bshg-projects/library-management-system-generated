package org.bshg.librarysystem.services.content.publisher;

import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.repository.content.PublisherDao;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublisherServiceImpl extends ServiceImpl<Publisher, PublisherDao> implements PublisherService {
    public PublisherServiceImpl(PublisherDao dao) {
        super(dao);
    }

    @Override
    public List<Publisher> findAllOptimized() {
        return dao.findAllOptimized();
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