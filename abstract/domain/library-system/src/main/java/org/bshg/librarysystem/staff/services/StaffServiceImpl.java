
package org.bshg.librarysystem.staff.services;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.StaffDao;
import org.bshg.librarysystem.staff.services.StaffService;
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