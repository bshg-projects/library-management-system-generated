package org.bshg.librarysystem.sprocess.user.staff.create;

import org.bshg.librarysystem.entity.core.user.Staff;

import java.util.List;

public interface CreateStaffProcess {
    Staff run(Staff item);

    List<Staff> run(List<Staff> items);
}