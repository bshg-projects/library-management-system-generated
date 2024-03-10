package org.bshg.librarysystem.employeeassignment.sprocess.update;

import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateEmployeeAssignmentProcessImpl implements UpdateEmployeeAssignmentProcess {
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAssignment run(EmployeeAssignment item) { // Your Logic To Update 'EmployeeAssignment'
        item = service.edit(item);
        return item;
    }

    public List<EmployeeAssignment> run(List<EmployeeAssignment> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private EmployeeAssignmentService service;
}