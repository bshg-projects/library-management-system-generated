package org.bshg.librarysystem.sprocess.event.payment.update;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdatePaymentProcessImpl extends AbstractUpdateProcessImpl<Payment, PaymentService> implements UpdatePaymentProcess {
    public UpdatePaymentProcessImpl(PaymentService service, ClientService clientService) {
        super(service);
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Payment run(Payment item) {
// Your Update Logic For 'Payment'
        item = service.edit(item);
        return item;
    }

    private ClientService clientService;
    private UpdateClientProcess updateClientProcess;
    private DeleteClientProcess deleteClientProcess;

    public void setUpdateClientProcess(UpdateClientProcess value) {
        this.updateClientProcess = value;
    }

    public void setDeleteClientProcess(DeleteClientProcess value) {
        this.deleteClientProcess = value;
    }
}