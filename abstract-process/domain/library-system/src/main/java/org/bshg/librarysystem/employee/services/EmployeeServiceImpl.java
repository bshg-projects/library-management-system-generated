package org.bshg.librarysystem.employee.services;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.EmployeeDao;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
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