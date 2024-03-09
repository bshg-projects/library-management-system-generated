
package org.bshg.librarysystem.sprocess.user.staff.delete;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.user.staff.StaffService;
import org.bshg.librarysystem.sprocess.user.staff.delete.DeleteStaffProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteStaffProcessImpl implements DeleteStaffProcess {
private void process(Staff item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Staff item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Staff item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Staff item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Staff> items) {
items.forEach(this::process);
service.delete(items);
}
@Autowired private StaffService service;
}