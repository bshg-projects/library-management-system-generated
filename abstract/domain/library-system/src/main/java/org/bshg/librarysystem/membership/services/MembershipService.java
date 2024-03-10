package org.bshg.librarysystem.membership.services;

import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.utils.service.IService;

public interface MembershipService extends IService<Membership> {
    int deleteByClientId(Long id);

    Membership findByClientId(Long id);
}