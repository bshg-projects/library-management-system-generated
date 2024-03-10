package org.bshg.librarysystem.sprocess.library.membership.create;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.library.membership.MembershipService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateMembershipProcessImpl implements CreateMembershipProcess {
    @Transactional(rollbackFor = Exception.class)
    public Membership run(Membership item) {
// Your Creation Logic For 'Membership'
        item = service.create(item);
        return item;
    }

    public List<Membership> run(List<Membership> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private MembershipService service;
    @Autowired
    private ClientService clientService;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
}