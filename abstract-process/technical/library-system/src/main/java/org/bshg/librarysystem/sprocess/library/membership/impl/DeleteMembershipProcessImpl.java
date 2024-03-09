
package org.bshg.librarysystem.sprocess.library.membership.impl;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.sprocess.library.membership.facade.DeleteMembershipProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteMembershipProcessImpl extends AbstractDeleteProcessImpl<Membership, MembershipService> implements DeleteMembershipProcess {
public DeleteMembershipProcessImpl(MembershipService service, ClientService clientService) {
super(service);
this.clientService = clientService;
}
@Override
protected void process(Membership item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void deleteByClient(Client client) {
if (client != null && client.getId() != null){
service.deleteByClientId(client.getId());
}
}
private ClientService clientService;
private DeleteClientProcess deleteClientProcess;
public void setDeleteClientProcess(DeleteClientProcess value) {
this.deleteClientProcess = value;
}
}