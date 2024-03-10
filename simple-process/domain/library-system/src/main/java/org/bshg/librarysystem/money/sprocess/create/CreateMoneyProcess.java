package org.bshg.librarysystem.money.sprocess.create;

import org.bshg.librarysystem.money.Money;

import java.util.List;

public interface CreateMoneyProcess {
    Money run(Money item);

    List<Money> run(List<Money> items);
}