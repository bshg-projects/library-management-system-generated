package org.bshg.librarysystem.services.user.admin.employee;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.repository.user.admin.EmployeeDao;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl extends ServiceImpl<Employee, EmployeeDao> implements EmployeeService {
public EmployeeServiceImpl(EmployeeDao dao) {
super(dao);
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