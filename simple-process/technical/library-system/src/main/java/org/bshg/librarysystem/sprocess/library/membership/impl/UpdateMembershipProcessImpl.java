package org.bshg.librarysystem.sprocess.library.membership.impl;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.sprocess.library.membership.facade.UpdateMembershipProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private MembershipService service;
}