package org.bshg.librarysystem.sprocess.event.money.impl;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.services.facade.event.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.facade.CreateMoneyProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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