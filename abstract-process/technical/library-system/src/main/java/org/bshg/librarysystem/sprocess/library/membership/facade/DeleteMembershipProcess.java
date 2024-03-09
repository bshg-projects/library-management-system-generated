package org.bshg.librarysystem.sprocess.library.membership.facade;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.user.Client;
public interface DeleteMembershipProcess extends IDeleteProcess<Membership> {
void deleteByClient(Client client);
}