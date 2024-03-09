package org.bshg.librarysystem.sprocess.user.staff.facade;
import org.bshg.librarysystem.entity.core.user.Staff;
import java.util.List;
public interface DeleteStaffProcess {
void run(Staff item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Staff> items);
}