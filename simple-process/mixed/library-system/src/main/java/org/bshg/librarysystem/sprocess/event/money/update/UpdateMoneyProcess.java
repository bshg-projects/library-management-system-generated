package org.bshg.librarysystem.sprocess.event.money.update;

import org.bshg.librarysystem.entity.core.event.Money;

import java.util.List;

public interface UpdateMoneyProcess {
    Money run(Money item);

    List<Money> run(List<Money> items);
}
