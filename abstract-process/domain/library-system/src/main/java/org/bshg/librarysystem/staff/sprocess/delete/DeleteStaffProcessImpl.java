
package org.bshg.librarysystem.staff.sprocess.delete;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.services.StaffService;
import org.bshg.librarysystem.staff.sprocess.delete.DeleteStaffProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteStaffProcessImpl extends AbstractDeleteProcessImpl<Staff, StaffService> implements DeleteStaffProcess {
public DeleteStaffProcessImpl(StaffService service) {
super(service);
}
@Override
protected void process(Staff item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
}