package org.bshg.librarysystem.membership;
import org.bshg.librarysystem.membership.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MembershipDao extends JpaRepository<Membership, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
Membership findByClientId(Long id);
@Query("SELECT NEW Membership(item.id,item.name) FROM Membership item")
List<Membership> findAllOptimized();
}