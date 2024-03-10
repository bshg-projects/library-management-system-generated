package org.bshg.librarysystem.membership.sprocess.create;

import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateMembershipProcessImpl extends AbstractCreateProcessImpl<Membership, MembershipService> implements CreateMembershipProcess {
    public CreateMembershipProcessImpl(MembershipService service, ClientService clientService) {
        super(service);
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Membership run(Membership item) {
// Your Insert Logic For 'Membership'
        item = service.create(item);
        return item;
    }

    private ClientService clientService;
    private CreateClientProcess createClientProcess;

    public void setCreateClientProcess(CreateClientProcess value) {
        this.createClientProcess = value;
    }
}