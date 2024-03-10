package org.bshg.librarysystem.services.user.admin.admin;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.repository.user.admin.AdminDao;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
        ServiceHelper.updateList(item, employeeAssignmentService::findByAdminId, Admin::getEmployeeAssignment, EmployeeAssignment::setAdmin, employeeAssignmentService);
    }

    @Lazy
    @Autowired
    private EmployeeAssignmentService employeeAssignmentService;
}