package org.bshg.librarysystem.services.facade.event;
import org.bshg.librarysystem.entity.core.event.Money;
import java.util.List;
public interface MoneyService {
Money findById(Long id);
List<Money> findAllOptimized();
List<Money> findAll();
Money create(Money item);
List<Money> create(List<Money> item);
Money update(Money item);
List<Money> update(List<Money> item);
void deleteById(Long id);
void delete(Money item);
void delete(List<Money> items);
void deleteByIdIn(List<Long> ids);
}