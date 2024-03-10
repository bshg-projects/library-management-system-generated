package org.bshg.librarysystem.sprocess.library.address.facade;

import org.bshg.librarysystem.entity.core.library.Address;

import java.util.List;

public interface CreateAddressProcess {
    Address run(Address item);

    List<Address> run(List<Address> items);
}