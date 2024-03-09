package org.bshg.librarysystem.sprocess.user.staff.update;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.user.staff.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.update.UpdateStaffProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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