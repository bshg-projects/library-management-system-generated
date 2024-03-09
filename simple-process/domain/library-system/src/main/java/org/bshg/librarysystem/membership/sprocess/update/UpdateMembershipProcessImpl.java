package org.bshg.librarysystem.membership.sprocess.update;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.membership.sprocess.update.UpdateMembershipProcess;
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