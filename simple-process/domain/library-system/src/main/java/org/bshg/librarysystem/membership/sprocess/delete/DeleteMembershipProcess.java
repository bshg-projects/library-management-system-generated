package org.bshg.librarysystem.membership.sprocess.delete;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.client.Client;
import java.util.List;
public interface DeleteMembershipProcess {
void run(Membership item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Membership> items);
void deleteByClient(Client client);
}