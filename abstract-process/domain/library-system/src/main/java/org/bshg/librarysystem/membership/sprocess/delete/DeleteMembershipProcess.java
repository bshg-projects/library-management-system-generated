package org.bshg.librarysystem.membership.sprocess.delete;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.client.Client;
public interface DeleteMembershipProcess extends IDeleteProcess<Membership> {
void deleteByClient(Client client);
}