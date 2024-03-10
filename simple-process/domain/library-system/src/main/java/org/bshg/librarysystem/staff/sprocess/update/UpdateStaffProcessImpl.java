package org.bshg.librarysystem.staff.sprocess.update;

import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.services.StaffService;
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