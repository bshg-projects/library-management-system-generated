package org.bshg.librarysystem.services.facade.library;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.entity.core.library.Address;
import java.util.List;
public interface CountryService {
Country findById(Long id);
List<Country> findAllOptimized();
List<Country> findAll();
Country create(Country item);
Country edit(Country item);
void deleteById(Long id);
void delete(Country item);
void delete(List<Country> items);
void deleteByIdIn(List<Long> ids);
}