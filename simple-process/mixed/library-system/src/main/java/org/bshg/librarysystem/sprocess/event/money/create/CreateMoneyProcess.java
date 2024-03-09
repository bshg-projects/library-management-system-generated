package org.bshg.librarysystem.sprocess.event.money.create;
import org.bshg.librarysystem.entity.core.event.Money;
import java.util.List;
public interface CreateMoneyProcess {
Money run(Money item);
List<Money> run(List<Money> items);
}