package org.bshg.librarysystem.publisher.services;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.PublisherDao;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
public int deleteByAddressId(Long id){
return dao.deleteByAddressId(id);
}
@Override
public Publisher findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Autowired private AddressService addressService;
}