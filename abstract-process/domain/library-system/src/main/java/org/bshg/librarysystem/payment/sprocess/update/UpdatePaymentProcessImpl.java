package org.bshg.librarysystem.payment.sprocess.update;

import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
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