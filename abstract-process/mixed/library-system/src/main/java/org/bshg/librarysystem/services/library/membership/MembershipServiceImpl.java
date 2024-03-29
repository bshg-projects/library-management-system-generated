package org.bshg.librarysystem.services.library.membership;

import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.repository.library.MembershipDao;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public int deleteByClientId(Long id) {
        return dao.deleteByClientId(id);
    }

    @Override
    public Membership findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    @Autowired
    private ClientService clientService;
}