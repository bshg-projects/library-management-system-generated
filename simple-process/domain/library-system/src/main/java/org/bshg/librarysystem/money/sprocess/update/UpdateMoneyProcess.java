package org.bshg.librarysystem.money.sprocess.update;

import org.bshg.librarysystem.money.Money;
import java.util.List;

public interface UpdateMoneyProcess {
    Money run(Money item);
    List<Money> run(List<Money> items);
}
