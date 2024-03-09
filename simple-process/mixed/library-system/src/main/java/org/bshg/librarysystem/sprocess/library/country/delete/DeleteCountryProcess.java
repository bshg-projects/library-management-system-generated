package org.bshg.librarysystem.sprocess.library.country.delete;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.entity.core.library.Address;
import java.util.List;
public interface DeleteCountryProcess {
void run(Country item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Country> items);
}