package org.bshg.librarysystem.country.services;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.CountryDao;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CountryServiceImpl extends ServiceImpl<Country, CountryDao> implements CountryService {
public CountryServiceImpl(CountryDao dao) {
super(dao);
}
@Override
public List<Country> findAllOptimized() {
return dao.findAllOptimized();
}
}