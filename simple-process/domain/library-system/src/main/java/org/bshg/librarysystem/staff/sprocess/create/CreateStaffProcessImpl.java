package org.bshg.librarysystem.staff.sprocess.create;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.services.StaffService;
import org.bshg.librarysystem.staff.sprocess.create.CreateStaffProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateStaffProcessImpl implements CreateStaffProcess {
@Transactional(rollbackFor = Exception.class)
public Staff run(Staff item) {
// Your Creation Logic For 'Staff'
item = service.create(item);
return item;
}
public List<Staff> run(List<Staff> items) {
items.forEach(this::run);
return items;
}
@Autowired private StaffService service;
}