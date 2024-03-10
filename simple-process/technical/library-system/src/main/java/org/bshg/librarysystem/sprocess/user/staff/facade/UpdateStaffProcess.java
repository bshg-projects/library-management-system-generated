package org.bshg.librarysystem.sprocess.user.staff.facade;

import org.bshg.librarysystem.entity.core.user.Staff;

import java.util.List;

public interface UpdateStaffProcess {
    Staff run(Staff item);

    List<Staff> run(List<Staff> items);
}
