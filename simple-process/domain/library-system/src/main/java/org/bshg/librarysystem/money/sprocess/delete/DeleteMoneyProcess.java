package org.bshg.librarysystem.money.sprocess.delete;
import org.bshg.librarysystem.money.Money;
import java.util.List;
public interface DeleteMoneyProcess {
void run(Money item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Money> items);
}