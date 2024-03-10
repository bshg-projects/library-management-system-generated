package org.bshg.librarysystem.services.impl.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.repository.user.admin.EmployeeAssignmentDao;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeAssignmentServiceImpl implements EmployeeAssignmentService {
    @Autowired
    EmployeeAssignmentDao dao;

    @Override
    public EmployeeAssignment findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeAssignment> findAll() {
        return dao.findAll();
    }

    public List<EmployeeAssignment> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public EmployeeAssignment create(EmployeeAssignment item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public EmployeeAssignment edit(EmployeeAssignment item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(EmployeeAssignment item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<EmployeeAssignment> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAdminId(Long id) {
        return dao.deleteByAdminId(id);
    }

    @Override
    public List<EmployeeAssignment> findByAdminId(Long id) {
        return dao.findByAdminId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByEmployeeId(Long id) {
        return dao.deleteByEmployeeId(id);
    }

    @Override
    public List<EmployeeAssignment> findByEmployeeId(Long id) {
        return dao.findByEmployeeId(id);
    }

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
}