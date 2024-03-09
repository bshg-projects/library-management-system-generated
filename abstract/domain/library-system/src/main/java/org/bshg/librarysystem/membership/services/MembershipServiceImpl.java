
package org.bshg.librarysystem.membership.services;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.MembershipDao;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class MembershipServiceImpl extends ServiceImpl<Membership, MembershipDao> implements MembershipService {
public MembershipServiceImpl(MembershipDao dao) {
super(dao);
}
@Override
public List<Membership> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
return dao.deleteByClientId(id);
}
@Override
public Membership findByClientId(Long id){
return dao.findByClientId(id);
}
@Lazy @Autowired private ClientService clientService;
}