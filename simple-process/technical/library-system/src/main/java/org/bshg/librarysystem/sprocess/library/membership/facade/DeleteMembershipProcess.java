package org.bshg.librarysystem.sprocess.library.membership.facade;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.entity.core.user.Client;
import java.util.List;
public interface DeleteMembershipProcess {
void run(Membership item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Membership> items);
void deleteByClient(Client client);
}