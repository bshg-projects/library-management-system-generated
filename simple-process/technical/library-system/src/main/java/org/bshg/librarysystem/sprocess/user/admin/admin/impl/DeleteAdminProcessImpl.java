package org.bshg.librarysystem.sprocess.user.admin.admin.impl;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteAdminProcessImpl implements DeleteAdminProcess {
    private void process(Admin item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Admin item) {
        process(item);
        deleteAssociated(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Admin item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Admin item = service.findById(id);
            if (item != null) {
                process(item);
                deleteAssociated(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Admin> items) {
        items.forEach(this::process);
        items.forEach(this::deleteAssociated);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociated(Admin item) {
        if (item == null || item.getId() == null) return;
        deleteAssociatedList(item);
    }

    private void deleteAssociatedList(Admin item) {
        deleteEmployeeAssignmentProcess.deleteByAdmin(item);
    }

    @Autowired
    private AdminService service;
    @Autowired
    @Lazy
    private EmployeeAssignmentService employeeAssignmentService;
    @Autowired
    @Lazy
    private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}