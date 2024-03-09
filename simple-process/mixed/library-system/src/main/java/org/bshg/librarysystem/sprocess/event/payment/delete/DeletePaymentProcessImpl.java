
package org.bshg.librarysystem.sprocess.event.payment.delete;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.delete.DeletePaymentProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeletePaymentProcessImpl implements DeletePaymentProcess {
private void process(Payment item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Payment item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Payment item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Payment item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Payment> items) {
items.forEach(this::process);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByClient(Client client) {
if (client != null && client.getId() != null){
service.deleteByClientId(client.getId());
}
}
@Autowired private PaymentService service;
@Autowired @Lazy private ClientService clientService;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
}