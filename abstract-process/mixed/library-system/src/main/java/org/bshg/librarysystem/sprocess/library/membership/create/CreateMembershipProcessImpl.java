package org.bshg.librarysystem.sprocess.library.membership.create;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.library.membership.MembershipService;
import org.bshg.librarysystem.sprocess.library.membership.create.CreateMembershipProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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