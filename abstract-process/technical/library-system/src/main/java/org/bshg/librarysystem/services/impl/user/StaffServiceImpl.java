package org.bshg.librarysystem.services.impl.user;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.repository.user.StaffDao;
import org.bshg.librarysystem.services.facade.user.StaffService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class StaffServiceImpl extends ServiceImpl<Staff, StaffDao> implements StaffService {
public StaffServiceImpl(StaffDao dao) {
super(dao);
}
}