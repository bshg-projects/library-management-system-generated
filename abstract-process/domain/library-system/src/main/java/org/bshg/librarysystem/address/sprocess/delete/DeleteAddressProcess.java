package org.bshg.librarysystem.address.sprocess.delete;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteAddressProcess extends IDeleteProcess<Address> {
    void deleteByCountry(Country country);
}