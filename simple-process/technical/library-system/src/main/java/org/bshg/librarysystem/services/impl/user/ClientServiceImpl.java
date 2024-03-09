package org.bshg.librarysystem.services.impl.user;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.repository.user.ClientDao;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
@Autowired ClientDao dao;
@Override
public Client findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Client> findAll() {
return dao.findAll();
}
public List<Client> findAllOptimized() {
return dao.findAll();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Client create(Client item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Client edit(Client item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Client item) {
if (item == null)
return;
dao.deleteById(item.getId());
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(List<Client> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
}