package org.bshg.librarysystem.sprocess.user.staff.impl;

import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.facade.user.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.facade.UpdateStaffProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateStaffProcessImpl extends AbstractUpdateProcessImpl<Staff, StaffService> implements UpdateStaffProcess {
    public UpdateStaffProcessImpl(StaffService service) {
        super(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Staff run(Staff item) {
// Your Update Logic For 'Staff'
        item = service.edit(item);
        return item;
    }
}