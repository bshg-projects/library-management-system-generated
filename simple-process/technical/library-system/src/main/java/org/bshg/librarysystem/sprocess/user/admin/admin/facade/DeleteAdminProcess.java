package org.bshg.librarysystem.sprocess.user.admin.admin.facade;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import java.util.List;
public interface DeleteAdminProcess {
void run(Admin item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Admin> items);
}