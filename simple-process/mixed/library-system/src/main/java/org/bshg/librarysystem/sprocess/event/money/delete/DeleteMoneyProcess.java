package org.bshg.librarysystem.sprocess.event.money.delete;

import org.bshg.librarysystem.entity.core.event.Money;

import java.util.List;

public interface DeleteMoneyProcess {
    void run(Money item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Money> items);
}