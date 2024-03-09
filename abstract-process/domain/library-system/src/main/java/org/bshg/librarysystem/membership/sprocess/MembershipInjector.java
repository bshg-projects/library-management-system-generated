package org.bshg.librarysystem.membership.sprocess;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.membership.sprocess.create.CreateMembershipProcess;
import org.bshg.librarysystem.membership.sprocess.update.UpdateMembershipProcess;
import org.bshg.librarysystem.membership.sprocess.delete.DeleteMembershipProcess;
import org.bshg.librarysystem.membership.sprocess.create.CreateMembershipProcessImpl;
import org.bshg.librarysystem.membership.sprocess.update.UpdateMembershipProcessImpl;
import org.bshg.librarysystem.membership.sprocess.delete.DeleteMembershipProcessImpl;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
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