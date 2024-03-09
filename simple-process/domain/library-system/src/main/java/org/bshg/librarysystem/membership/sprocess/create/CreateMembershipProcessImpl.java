package org.bshg.librarysystem.membership.sprocess.create;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.membership.sprocess.create.CreateMembershipProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private MembershipService service;
@Autowired private ClientService clientService;
@Autowired @Lazy private CreateClientProcess createClientProcess;
}