package org.bshg.librarysystem.address.sprocess.delete;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.country.Country;
import java.util.List;
public interface DeleteAddressProcess {
void run(Address item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Address> items);
void deleteByCountry(Country country);
}