package org.bshg.librarysystem.repository.library;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CountryDao extends Repository<Country, Long> {
@Query("SELECT NEW Country(item.id,item.name) FROM Country item")
List<Country> findAllOptimized();
}