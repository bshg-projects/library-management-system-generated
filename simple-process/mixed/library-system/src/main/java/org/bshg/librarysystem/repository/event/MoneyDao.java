package org.bshg.librarysystem.repository.event;

import org.bshg.librarysystem.entity.core.event.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoneyDao extends JpaRepository<Money, Long> {
    int deleteByIdIn(List<Long> ids);

    @Query("SELECT NEW Money(item.id,item.name) FROM Money item")
    List<Money> findAllOptimized();
}