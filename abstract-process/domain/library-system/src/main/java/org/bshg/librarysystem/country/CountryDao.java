package org.bshg.librarysystem.country;
import org.bshg.librarysystem.country.Country;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CountryDao extends Repository<Country, Long> {
@Query("SELECT NEW Country(item.id,item.name) FROM Country item")
List<Country> findAllOptimized();
}