
package org.bshg.librarysystem.sprocess.event.money.delete;
import org.bshg.librarysystem.entity.core.event.Money;
import org.bshg.librarysystem.services.event.money.MoneyService;
import org.bshg.librarysystem.sprocess.event.money.delete.DeleteMoneyProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteMoneyProcessImpl implements DeleteMoneyProcess {
private void process(Money item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Money item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Money item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Money item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Money> items) {
items.forEach(this::process);
service.delete(items);
}
@Autowired private MoneyService service;
}