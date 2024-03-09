package org.bshg.librarysystem.services.impl.user;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.repository.user.StaffDao;
import org.bshg.librarysystem.services.facade.user.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
@Autowired StaffDao dao;
@Override
public Staff findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Staff> findAll() {
return dao.findAll();
}
public List<Staff> findAllOptimized() {
return dao.findAll();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Staff create(Staff item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Staff edit(Staff item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Staff item) {
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
public void delete(List<Staff> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
}