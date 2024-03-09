package org.bshg.librarysystem.address.services;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface AddressService extends IService<Address> {
int deleteByCountryId(Long id);
List<Address> findByCountryId(Long id);
}