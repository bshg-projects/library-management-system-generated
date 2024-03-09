
package org.bshg.librarysystem.money.sprocess.delete;
import org.bshg.librarysystem.money.Money;
import org.bshg.librarysystem.money.services.MoneyService;
import org.bshg.librarysystem.money.sprocess.delete.DeleteMoneyProcess;
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