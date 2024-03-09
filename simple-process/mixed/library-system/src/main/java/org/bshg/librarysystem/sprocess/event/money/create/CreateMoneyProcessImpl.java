package org.bshg.librarysystem.sprocess.event.money.create;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.services.event.money.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.create.CreateMoneyProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateMoneyProcessImpl implements CreateMoneyProcess {
@Transactional(rollbackFor = Exception.class)
public Money run(Money item) {
// Your Creation Logic For 'Money'
item = service.create(item);
return item;
}
public List<Money> run(List<Money> items) {
items.forEach(this::run);
return items;
}
@Autowired private MoneyService service;
}