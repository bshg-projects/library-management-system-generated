package org.bshg.librarysystem.employeeassignment.services;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignmentDao;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmployeeAssignmentServiceImpl extends ServiceImpl<EmployeeAssignment, EmployeeAssignmentDao> implements EmployeeAssignmentService {
public EmployeeAssignmentServiceImpl(EmployeeAssignmentDao dao) {
super(dao);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAdminId(Long id){
return dao.deleteByAdminId(id);
}
@Override
public List<EmployeeAssignment> findByAdminId(Long id){
return dao.findByAdminId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByEmployeeId(Long id){
return dao.deleteByEmployeeId(id);
}
@Override
public List<EmployeeAssignment> findByEmployeeId(Long id){
return dao.findByEmployeeId(id);
}
@Autowired private AdminService adminService;
@Autowired private EmployeeService employeeService;
}