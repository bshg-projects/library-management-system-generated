package org.bshg.librarysystem.sprocess.library.country.impl;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.UpdateCountryProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateCountryProcessImpl implements UpdateCountryProcess {
    @Transactional(rollbackFor = Exception.class)
    public Country run(Country item) { // Your Logic To Update 'Country'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    public List<Country> run(List<Country> items) {
        items.forEach(this::run);
        return items;
    }

    public void updateAssociatedList(Country item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                addressService.findByCountryId(item.getId()),
                item.getAddresses(),
                Address::setCountry,
                updateAddressProcess::run,
                deleteAddressProcess::run
        );
    }

    @Autowired
    private CountryService service;
    @Autowired
    AddressService addressService;
    @Autowired
    @Lazy
    private UpdateAddressProcess updateAddressProcess;
    @Autowired
    @Lazy
    private DeleteAddressProcess deleteAddressProcess;
}