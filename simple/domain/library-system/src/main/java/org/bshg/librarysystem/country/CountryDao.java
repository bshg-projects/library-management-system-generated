package org.bshg.librarysystem.country;
import org.bshg.librarysystem.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CountryDao extends JpaRepository<Country, Long> {
int deleteByIdIn(List<Long> ids);
@Query("SELECT NEW Country(item.id,item.name) FROM Country item")
List<Country> findAllOptimized();
}