
package org.bshg.librarysystem.admin.services;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.AdminDao;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AdminServiceImpl extends ServiceImpl<Admin, AdminDao> implements AdminService {
public AdminServiceImpl(AdminDao dao) {
super(dao);
}
@Override
public void deleteAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
employeeAssignmentService.deleteByAdminId(item.getId());
}
@Override
public void createAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Admin::getEmployeeAssignment, EmployeeAssignment::setAdmin, employeeAssignmentService);
}
@Override
public void updateAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,employeeAssignmentService::findByAdminId,Admin::getEmployeeAssignment,EmployeeAssignment::setAdmin,employeeAssignmentService);
}
@Lazy @Autowired private EmployeeAssignmentService employeeAssignmentService;
}