package org.bshg.librarysystem.membership.sprocess.update;

import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateMembershipProcessImpl implements UpdateMembershipProcess {
    @Transactional(rollbackFor = Exception.class)
    public Membership run(Membership item) { // Your Logic To Update 'Membership'
        item = service.edit(item);
        return item;
    }

    public List<Membership> run(List<Membership> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private MembershipService service;
}