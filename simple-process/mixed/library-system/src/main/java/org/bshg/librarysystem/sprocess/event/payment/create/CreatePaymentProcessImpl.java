package org.bshg.librarysystem.sprocess.event.payment.create;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.create.CreatePaymentProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreatePaymentProcessImpl implements CreatePaymentProcess {
@Transactional(rollbackFor = Exception.class)
public Payment run(Payment item) {
// Your Creation Logic For 'Payment'
item = service.create(item);
return item;
}
public List<Payment> run(List<Payment> items) {
items.forEach(this::run);
return items;
}
@Autowired private PaymentService service;
@Autowired private ClientService clientService;
@Autowired @Lazy private CreateClientProcess createClientProcess;
}