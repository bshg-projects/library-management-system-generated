package org.bshg.librarysystem.sprocess.user.staff.impl;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.facade.user.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.facade.CreateStaffProcess;
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