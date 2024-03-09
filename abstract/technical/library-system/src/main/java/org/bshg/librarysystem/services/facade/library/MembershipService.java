package org.bshg.librarysystem.services.facade.library;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface MembershipService extends IService<Membership> {
int deleteByClientId(Long id);
Membership findByClientId(Long id);
}