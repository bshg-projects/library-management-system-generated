package org.bshg.librarysystem.money.sprocess.create;

import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.money.services.MoneyService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateMoneyProcessImpl extends AbstractCreateProcessImpl<Money, MoneyService> implements CreateMoneyProcess {
    public CreateMoneyProcessImpl(MoneyService service) {
        super(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Money run(Money item) {
// Your Insert Logic For 'Money'
        item = service.create(item);
        return item;
    }
}