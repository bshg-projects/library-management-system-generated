package org.bshg.librarysystem.sprocess.library.membership.create;
import org.bshg.librarysystem.entity.core.library.Membership;
import java.util.List;
public interface CreateMembershipProcess {
Membership run(Membership item);
List<Membership> run(List<Membership> items);
}