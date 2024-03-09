package org.bshg.librarysystem.address.sprocess.update;

import org.bshg.librarysystem.address.Address;
import java.util.List;

public interface UpdateAddressProcess {
    Address run(Address item);
    List<Address> run(List<Address> items);
}
