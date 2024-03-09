package org.bshg.librarysystem.address.sprocess.create;
import org.bshg.librarysystem.address.Address;
import java.util.List;
public interface CreateAddressProcess {
Address run(Address item);
List<Address> run(List<Address> items);
}