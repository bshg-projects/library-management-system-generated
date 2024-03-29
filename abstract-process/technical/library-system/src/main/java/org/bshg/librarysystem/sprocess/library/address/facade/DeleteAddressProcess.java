package org.bshg.librarysystem.sprocess.library.address.facade;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteAddressProcess extends IDeleteProcess<Address> {
    void deleteByCountry(Country country);
}