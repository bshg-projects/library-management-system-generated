package org.bshg.librarysystem.sprocess.event.payment.impl;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.event.payment.facade.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreatePaymentProcessImpl extends AbstractCreateProcessImpl<Payment, PaymentService> implements CreatePaymentProcess {
    public CreatePaymentProcessImpl(PaymentService service, ClientService clientService) {
        super(service);
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Payment run(Payment item) {
// Your Insert Logic For 'Payment'
        item = service.create(item);
        return item;
    }

    private ClientService clientService;
    private CreateClientProcess createClientProcess;

    public void setCreateClientProcess(CreateClientProcess value) {
        this.createClientProcess = value;
    }
}