package org.bshg.librarysystem.admin.sprocess.update;

import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateAdminProcessImpl implements UpdateAdminProcess {
    @Transactional(rollbackFor = Exception.class)
    public Admin run(Admin item) { // Your Logic To Update 'Admin'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    public List<Admin> run(List<Admin> items) {
        items.forEach(this::run);
        return items;
    }

    public void updateAssociatedList(Admin item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                employeeAssignmentService.findByAdminId(item.getId()),
                item.getEmployeeAssignment(),
                EmployeeAssignment::setAdmin,
                updateEmployeeAssignmentProcess::run,
                deleteEmployeeAssignmentProcess::run
        );
    }

    @Autowired
    private AdminService service;
    @Autowired
    EmployeeAssignmentService employeeAssignmentService;
    @Autowired
    @Lazy
    private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}