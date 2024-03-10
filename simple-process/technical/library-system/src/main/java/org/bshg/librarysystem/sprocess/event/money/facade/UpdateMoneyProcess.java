package org.bshg.librarysystem.sprocess.event.money.facade;

import org.bshg.librarysystem.entity.core.event.Money;

import java.util.List;

public interface UpdateMoneyProcess {
    Money run(Money item);

    List<Money> run(List<Money> items);
}
