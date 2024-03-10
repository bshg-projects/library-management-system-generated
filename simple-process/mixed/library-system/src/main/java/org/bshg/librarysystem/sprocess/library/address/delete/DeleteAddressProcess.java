package org.bshg.librarysystem.sprocess.library.address.delete;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Country;

import java.util.List;

public interface DeleteAddressProcess {
    void run(Address item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Address> items);

    void deleteByCountry(Country country);
}