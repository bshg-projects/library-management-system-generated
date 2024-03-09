package org.bshg.librarysystem.membership.sprocess.update;

import org.bshg.librarysystem.membership.Membership;
import java.util.List;

public interface UpdateMembershipProcess {
    Membership run(Membership item);
    List<Membership> run(List<Membership> items);
}
