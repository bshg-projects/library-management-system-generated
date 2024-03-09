package org.bshg.librarysystem.membership.sprocess.update;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.membership.sprocess.update.UpdateMembershipProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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