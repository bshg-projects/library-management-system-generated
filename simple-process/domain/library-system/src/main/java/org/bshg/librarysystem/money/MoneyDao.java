package org.bshg.librarysystem.money;
import org.bshg.librarysystem.money.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MoneyDao extends JpaRepository<Money, Long> {
int deleteByIdIn(List<Long> ids);
@Query("SELECT NEW Money(item.id,item.name) FROM Money item")
List<Money> findAllOptimized();
}