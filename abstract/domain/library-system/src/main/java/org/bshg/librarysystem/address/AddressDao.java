package org.bshg.librarysystem.address;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AddressDao extends Repository<Address, Long> {
int deleteByCountryId(Long id);
List<Address> findByCountryId(Long id);
}