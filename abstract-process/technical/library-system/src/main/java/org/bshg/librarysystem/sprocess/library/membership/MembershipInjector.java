package org.bshg.librarysystem.sprocess.library.membership;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.sprocess.library.membership.facade.CreateMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.facade.UpdateMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.facade.DeleteMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.impl.CreateMembershipProcessImpl;
import org.bshg.librarysystem.sprocess.library.membership.impl.UpdateMembershipProcessImpl;
import org.bshg.librarysystem.sprocess.library.membership.impl.DeleteMembershipProcessImpl;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Membership Processes (Create, Update, Delete).
*/
@Configuration
public class MembershipInjector {
@Bean
public CreateMembershipProcess createMembershipProcess (MembershipService service,ClientService clientService) {
var bean = new CreateMembershipProcessImpl(service, clientService);
bean.setCreateClientProcess(this.createClientProcess);
return bean;
}
@Bean
public UpdateMembershipProcess updateMembershipProcess (MembershipService service,ClientService clientService) {
var bean = new UpdateMembershipProcessImpl(service,clientService);
bean.setUpdateClientProcess(this.updateClientProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Bean
public DeleteMembershipProcess deleteMembershipProcess(MembershipService service,ClientService clientService) {
var bean = new DeleteMembershipProcessImpl(service,clientService);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Autowired @Lazy private CreateClientProcess createClientProcess;
@Autowired @Lazy private UpdateClientProcess updateClientProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
}