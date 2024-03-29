package org.bshg.librarysystem.services.library.country;

import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.repository.library.CountryDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

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