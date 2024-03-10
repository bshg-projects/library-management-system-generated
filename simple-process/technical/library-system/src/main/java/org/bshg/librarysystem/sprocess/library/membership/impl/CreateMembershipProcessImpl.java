package org.bshg.librarysystem.sprocess.library.membership.impl;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.library.membership.facade.CreateMembershipProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
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