package org.bshg.librarysystem.sprocess.library.membership.impl;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.library.membership.facade.UpdateMembershipProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateMembershipProcessImpl extends AbstractUpdateProcessImpl<Membership, MembershipService> implements UpdateMembershipProcess {
    public UpdateMembershipProcessImpl(MembershipService service, ClientService clientService) {
        super(service);
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Membership run(Membership item) {
// Your Update Logic For 'Membership'
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