package org.bshg.librarysystem.sprocess.user.staff.impl;

import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.facade.user.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.facade.UpdateStaffProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateStaffProcessImpl implements UpdateStaffProcess {
    @Transactional(rollbackFor = Exception.class)
    public Staff run(Staff item) { // Your Logic To Update 'Staff'
        item = service.edit(item);
        return item;
    }

    public List<Staff> run(List<Staff> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private StaffService service;
}