package org.bshg.librarysystem.services.impl.library;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.repository.library.MembershipDao;
import org.bshg.librarysystem.services.facade.library.MembershipService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class MembershipServiceImpl implements MembershipService {
//--------------- FIND -------------------------------------
public Membership findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Membership> findAll() {
return dao.findAll();
}
public List<Membership> findAllOptimized() {
return dao.findAllOptimized();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Membership create(Membership item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Membership> create(List<Membership> items) {
List<Membership> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Membership update(Membership item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Membership> update(List<Membership> items) {
List<Membership> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Membership item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Membership item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Membership> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
return dao.deleteByClientId(id);
}
@Override
public Membership findByClientId(Long id){
return dao.findByClientId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private MembershipDao dao;
@Lazy @Autowired private ClientService clientService;
}