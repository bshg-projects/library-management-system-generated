package org.bshg.librarysystem.country.sprocess.update;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
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