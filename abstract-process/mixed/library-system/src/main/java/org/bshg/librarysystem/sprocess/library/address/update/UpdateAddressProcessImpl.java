package org.bshg.librarysystem.sprocess.library.address.update;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.sprocess.library.country.delete.DeleteCountryProcess;
import org.bshg.librarysystem.sprocess.library.country.update.UpdateCountryProcess;
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