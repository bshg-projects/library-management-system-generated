package org.bshg.librarysystem.country.sprocess.delete;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.address.Address;
import java.util.List;
public interface DeleteCountryProcess {
void run(Country item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Country> items);
}