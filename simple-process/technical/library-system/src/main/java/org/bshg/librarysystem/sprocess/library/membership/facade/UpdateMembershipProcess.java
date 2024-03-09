package org.bshg.librarysystem.sprocess.library.membership.facade;

import org.bshg.librarysystem.entity.core.library.Membership;
import java.util.List;

public interface UpdateMembershipProcess {
    Membership run(Membership item);
    List<Membership> run(List<Membership> items);
}
