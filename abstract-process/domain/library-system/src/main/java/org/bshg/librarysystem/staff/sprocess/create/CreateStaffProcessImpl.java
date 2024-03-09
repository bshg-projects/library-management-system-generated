package org.bshg.librarysystem.staff.sprocess.create;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.services.StaffService;
import org.bshg.librarysystem.staff.sprocess.create.CreateStaffProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateStaffProcessImpl extends AbstractCreateProcessImpl<Staff, StaffService> implements CreateStaffProcess {
public CreateStaffProcessImpl(StaffService service) {
super(service);
}
@Override
@Transactional(rollbackFor = Exception.class)
public Staff run(Staff item) {
// Your Insert Logic For 'Staff'
item = service.create(item);
return item;
}
}