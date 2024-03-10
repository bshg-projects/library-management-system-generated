package org.bshg.librarysystem.country.sprocess.delete;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.country.services.CountryService;
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