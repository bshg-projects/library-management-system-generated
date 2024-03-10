package org.bshg.librarysystem.sprocess.library.address.create;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.sprocess.library.country.create.CreateCountryProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateAddressProcessImpl implements CreateAddressProcess {
    @Transactional(rollbackFor = Exception.class)
    public Address run(Address item) {
// Your Creation Logic For 'Address'
        item = service.create(item);
        return item;
    }

    public List<Address> run(List<Address> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private AddressService service;
    @Autowired
    private CountryService countryService;
    @Autowired
    @Lazy
    private CreateCountryProcess createCountryProcess;
}