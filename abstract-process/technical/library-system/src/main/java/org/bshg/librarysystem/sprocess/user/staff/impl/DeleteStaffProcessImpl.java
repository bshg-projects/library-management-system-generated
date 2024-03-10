package org.bshg.librarysystem.sprocess.user.staff.impl;

import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.facade.user.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.facade.DeleteStaffProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteStaffProcessImpl extends AbstractDeleteProcessImpl<Staff, StaffService> implements DeleteStaffProcess {
    public DeleteStaffProcessImpl(StaffService service) {
        super(service);
    }

    @Override
    protected void process(Staff item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }
}