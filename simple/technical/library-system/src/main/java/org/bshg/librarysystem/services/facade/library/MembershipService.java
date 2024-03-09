package org.bshg.librarysystem.services.facade.library;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.entity.core.user.Client;
import java.util.List;
public interface MembershipService {
Membership findById(Long id);
List<Membership> findAllOptimized();
List<Membership> findAll();
Membership create(Membership item);
List<Membership> create(List<Membership> item);
Membership update(Membership item);
List<Membership> update(List<Membership> item);
void deleteById(Long id);
void delete(Membership item);
void delete(List<Membership> items);
void deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
Membership findByClientId(Long id);
}