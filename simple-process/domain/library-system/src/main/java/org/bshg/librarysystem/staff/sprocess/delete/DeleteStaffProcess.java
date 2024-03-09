package org.bshg.librarysystem.staff.sprocess.delete;
import org.bshg.librarysystem.staff.Staff;
import java.util.List;
public interface DeleteStaffProcess {
void run(Staff item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Staff> items);
}