package org.bshg.librarysystem.staff.sprocess.create;

import org.bshg.librarysystem.staff.Staff;

import java.util.List;

public interface CreateStaffProcess {
    Staff run(Staff item);

    List<Staff> run(List<Staff> items);
}