package org.bshg.librarysystem.country.services;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.CountryDao;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    @Override
    public void deleteAssociatedList(Country item) {
        if (item == null || item.getId() == null) return;
        addressService.deleteByCountryId(item.getId());
    }

    @Override
    public void createAssociatedList(Country item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Country::getAddresses, Address::setCountry, addressService);
    }

    @Override
    public void updateAssociatedList(Country item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(item, addressService::findByCountryId, Country::getAddresses, Address::setCountry, addressService);
    }

    @Lazy
    @Autowired
    private AddressService addressService;
}