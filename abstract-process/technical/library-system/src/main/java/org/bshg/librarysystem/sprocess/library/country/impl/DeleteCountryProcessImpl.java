package org.bshg.librarysystem.sprocess.library.country.impl;

import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.services.facade.library.CountryService;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.DeleteCountryProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteCountryProcessImpl extends AbstractDeleteProcessImpl<Country, CountryService> implements DeleteCountryProcess {
    public DeleteCountryProcessImpl(CountryService service, AddressService addressService) {
        super(service);
        this.addressService = addressService;
    }

    @Override
    protected void process(Country item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void deleteAssociatedList(Country item) {
        deleteAddressProcess.deleteByCountry(item);
    }

    private AddressService addressService;
    private DeleteAddressProcess deleteAddressProcess;

    public void setDeleteAddressProcess(DeleteAddressProcess value) {
        this.deleteAddressProcess = value;
    }
}