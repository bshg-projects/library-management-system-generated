package org.bshg.librarysystem.membership.services;

import org.bshg.librarysystem.membership.Membership;

import java.util.List;

public interface MembershipService {
    Membership findById(Long id);

    List<Membership> findAllOptimized();

    List<Membership> findAll();

    Membership create(Membership item);

    Membership edit(Membership item);

    void deleteById(Long id);

    void delete(Membership item);

    void delete(List<Membership> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByClientId(Long id);

    Membership findByClientId(Long id);
}