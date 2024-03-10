package org.bshg.librarysystem.sprocess.library.membership.delete;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteMembershipProcess extends IDeleteProcess<Membership> {
    void deleteByClient(Client client);
}