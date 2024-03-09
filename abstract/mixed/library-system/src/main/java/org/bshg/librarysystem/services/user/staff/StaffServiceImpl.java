
package org.bshg.librarysystem.services.user.staff;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.repository.user.StaffDao;
import org.bshg.librarysystem.services.user.staff.StaffService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class StaffServiceImpl extends ServiceImpl<Staff, StaffDao> implements StaffService {
public StaffServiceImpl(StaffDao dao) {
super(dao);
}
}