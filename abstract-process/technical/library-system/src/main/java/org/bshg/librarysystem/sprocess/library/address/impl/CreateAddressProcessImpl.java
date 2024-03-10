package org.bshg.librarysystem.sprocess.library.address.impl;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.CreateCountryProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateAddressProcessImpl extends AbstractCreateProcessImpl<Address, AddressService> implements CreateAddressProcess {
    public CreateAddressProcessImpl(AddressService service, CountryService countryService) {
        super(service);
        this.countryService = countryService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Address run(Address item) {
// Your Insert Logic For 'Address'
        item = service.create(item);
        return item;
    }

    private CountryService countryService;
    private CreateCountryProcess createCountryProcess;

    public void setCreateCountryProcess(CreateCountryProcess value) {
        this.createCountryProcess = value;
    }
}