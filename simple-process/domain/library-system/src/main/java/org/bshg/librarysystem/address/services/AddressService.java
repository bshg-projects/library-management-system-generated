package org.bshg.librarysystem.address.services;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.country.Country;
import java.util.List;
public interface AddressService {
Address findById(Long id);
List<Address> findAllOptimized();
List<Address> findAll();
Address create(Address item);
Address edit(Address item);
void deleteById(Long id);
void delete(Address item);
void delete(List<Address> items);
void deleteByIdIn(List<Long> ids);
int deleteByCountryId(Long id);
List<Address> findByCountryId(Long id);
}