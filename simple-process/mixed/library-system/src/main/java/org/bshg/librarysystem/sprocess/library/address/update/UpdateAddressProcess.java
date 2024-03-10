package org.bshg.librarysystem.sprocess.library.address.update;

import org.bshg.librarysystem.entity.core.library.Address;

import java.util.List;

public interface UpdateAddressProcess {
    Address run(Address item);

    List<Address> run(List<Address> items);
}
