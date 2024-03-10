package org.bshg.librarysystem.employeeassignment.sprocess.delete;

import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.delete.DeleteAdminProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteEmployeeAssignmentProcessImpl implements DeleteEmployeeAssignmentProcess {
    private void process(EmployeeAssignment item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(EmployeeAssignment item) {
        process(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        EmployeeAssignment item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            EmployeeAssignment item = service.findById(id);
            if (item != null) {
                process(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<EmployeeAssignment> items) {
        items.forEach(this::process);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByAdmin(Admin admin) {
        if (admin != null && admin.getId() != null) {
            service.deleteByAdminId(admin.getId());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByEmployee(Employee employee) {
        if (employee != null && employee.getId() != null) {
            service.deleteByEmployeeId(employee.getId());
        }
    }

    @Autowired
    private EmployeeAssignmentService service;
    @Autowired
    @Lazy
    private EmployeeService employeeService;
    @Autowired
    @Lazy
    private AdminService adminService;
    @Autowired
    @Lazy
    private DeleteAdminProcess deleteAdminProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeProcess deleteEmployeeProcess;
}