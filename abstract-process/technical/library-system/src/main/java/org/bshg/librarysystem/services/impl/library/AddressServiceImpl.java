package org.bshg.librarysystem.services.impl.library;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.repository.library.AddressDao;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AddressServiceImpl extends ServiceImpl<Address, AddressDao> implements AddressService {
public AddressServiceImpl(AddressDao dao) {
super(dao);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByCountryId(Long id){
return dao.deleteByCountryId(id);
}
@Override
public List<Address> findByCountryId(Long id){
return dao.findByCountryId(id);
}
@Autowired private CountryService countryService;
}