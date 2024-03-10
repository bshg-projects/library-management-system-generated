package org.bshg.librarysystem.sprocess.library.membership;

import org.bshg.librarysystem.services.library.membership.MembershipService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.library.membership.create.CreateMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.create.CreateMembershipProcessImpl;
import org.bshg.librarysystem.sprocess.library.membership.delete.DeleteMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.delete.DeleteMembershipProcessImpl;
import org.bshg.librarysystem.sprocess.library.membership.update.UpdateMembershipProcess;
import org.bshg.librarysystem.sprocess.library.membership.update.UpdateMembershipProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Membership Processes (Create, Update, Delete).
 */
@Configuration
public class MembershipInjector {
    @Bean
    public CreateMembershipProcess createMembershipProcess(MembershipService service, ClientService clientService) {
        var bean = new CreateMembershipProcessImpl(service, clientService);
        bean.setCreateClientProcess(this.createClientProcess);
        return bean;
    }

    @Bean
    public UpdateMembershipProcess updateMembershipProcess(MembershipService service, ClientService clientService) {
        var bean = new UpdateMembershipProcessImpl(service, clientService);
        bean.setUpdateClientProcess(this.updateClientProcess);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Bean
    public DeleteMembershipProcess deleteMembershipProcess(MembershipService service, ClientService clientService) {
        var bean = new DeleteMembershipProcessImpl(service, clientService);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
    @Autowired
    @Lazy
    private UpdateClientProcess updateClientProcess;
    @Autowired
    @Lazy
    private DeleteClientProcess deleteClientProcess;
}