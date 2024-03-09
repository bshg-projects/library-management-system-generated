package org.bshg.librarysystem.admin.services;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.AdminDao;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AdminServiceImpl extends ServiceImpl<Admin, AdminDao> implements AdminService {
public AdminServiceImpl(AdminDao dao) {
super(dao);
}
}