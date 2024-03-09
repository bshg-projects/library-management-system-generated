package org.bshg.librarysystem.sprocess.event.money.update;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.services.event.money.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.update.UpdateMoneyProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateMoneyProcessImpl extends AbstractUpdateProcessImpl<Money, MoneyService> implements UpdateMoneyProcess {
public UpdateMoneyProcessImpl(MoneyService service) {
super(service);
}
@Override
@Transactional(rollbackFor = Exception.class)
public Money run(Money item) {
// Your Update Logic For 'Money'
item = service.edit(item);
return item;
}
}