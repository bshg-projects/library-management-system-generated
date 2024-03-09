package org.bshg.librarysystem.membership.sprocess.create;
import org.bshg.librarysystem.membership.Membership;
import java.util.List;
public interface CreateMembershipProcess {
Membership run(Membership item);
List<Membership> run(List<Membership> items);
}