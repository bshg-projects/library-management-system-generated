package org.bshg.librarysystem.money.sprocess.update;
import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.money.services.MoneyService;
import org.bshg.librarysystem.money.sprocess.update.UpdateMoneyProcess;
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