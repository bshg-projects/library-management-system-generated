package org.bshg.librarysystem.repository.event;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MoneyDao extends Repository<Money, Long> {
@Query("SELECT NEW Money(item.id,item.name) FROM Money item")
List<Money> findAllOptimized();
}