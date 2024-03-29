package org.bshg.librarysystem.sprocess.event.money.impl;

import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.services.facade.event.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.facade.DeleteMoneyProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DeleteMoneyProcessImpl extends AbstractDeleteProcessImpl<Money, MoneyService> implements DeleteMoneyProcess {
    public DeleteMoneyProcessImpl(MoneyService service) {
        super(service);
    }

    @Override
    protected void process(Money item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }
}