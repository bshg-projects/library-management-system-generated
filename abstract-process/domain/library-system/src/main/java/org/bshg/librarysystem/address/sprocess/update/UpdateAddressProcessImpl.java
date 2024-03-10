package org.bshg.librarysystem.address.sprocess.update;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.country.services.CountryService;
import org.bshg.librarysystem.country.sprocess.delete.DeleteCountryProcess;
import org.bshg.librarysystem.country.sprocess.update.UpdateCountryProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateAddressProcessImpl extends AbstractUpdateProcessImpl<Address, AddressService> implements UpdateAddressProcess {
    public UpdateAddressProcessImpl(AddressService service, CountryService countryService) {
        super(service);
        this.countryService = countryService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Address run(Address item) {
// Your Update Logic For 'Address'
        item = service.edit(item);
        return item;
    }

    private CountryService countryService;
    private UpdateCountryProcess updateCountryProcess;
    private DeleteCountryProcess deleteCountryProcess;

    public void setUpdateCountryProcess(UpdateCountryProcess value) {
        this.updateCountryProcess = value;
    }

    public void setDeleteCountryProcess(DeleteCountryProcess value) {
        this.deleteCountryProcess = value;
    }
}