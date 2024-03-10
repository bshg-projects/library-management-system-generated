package org.bshg.librarysystem.staff.sprocess.update;

import org.bshg.librarysystem.staff.Staff;

import java.util.List;

public interface UpdateStaffProcess {
    Staff run(Staff item);

    List<Staff> run(List<Staff> items);
}
