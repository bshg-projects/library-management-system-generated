package org.bshg.librarysystem.services.impl.user.admin;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.repository.user.admin.EmployeeDao;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired EmployeeDao dao;
@Override
public Employee findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Employee> findAll() {
return dao.findAll();
}
public List<Employee> findAllOptimized() {
return dao.findAll();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Employee create(Employee item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Employee edit(Employee item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Employee item) {
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
public void delete(List<Employee> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAddressId(Long id){
return dao.deleteByAddressId(id);
}
@Override
public Employee findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Autowired private AddressService addressService;
}