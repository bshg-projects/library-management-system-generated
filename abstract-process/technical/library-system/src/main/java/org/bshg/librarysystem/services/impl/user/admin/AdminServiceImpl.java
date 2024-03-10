package org.bshg.librarysystem.services.impl.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.repository.user.admin.AdminDao;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<Admin, AdminDao> implements AdminService {
    public AdminServiceImpl(AdminDao dao) {
        super(dao);
    }
}