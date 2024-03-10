package org.bshg.librarysystem.staff.services;

import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.staff.StaffDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<Staff, StaffDao> implements StaffService {
    public StaffServiceImpl(StaffDao dao) {
        super(dao);
    }
}