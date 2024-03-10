package org.bshg.librarysystem.services.facade.library;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.utils.service.IService;

public interface MembershipService extends IService<Membership> {
    int deleteByClientId(Long id);

    Membership findByClientId(Long id);
}