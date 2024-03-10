package org.bshg.librarysystem.repository.library;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipDao extends Repository<Membership, Long> {
    int deleteByClientId(Long id);

    Membership findByClientId(Long id);

    @Query("SELECT NEW Membership(item.id,item.name) FROM Membership item")
    List<Membership> findAllOptimized();
}