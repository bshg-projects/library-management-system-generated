package org.bshg.librarysystem.employeeassignment.services;

import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeAssignmentServiceImpl implements EmployeeAssignmentService {
    //--------------- FIND -------------------------------------
    public EmployeeAssignment findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<EmployeeAssignment> findAll() {
        return dao.findAll();
    }

    public List<EmployeeAssignment> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAssignment create(EmployeeAssignment item) {
        if (item == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<EmployeeAssignment> create(List<EmployeeAssignment> items) {
        List<EmployeeAssignment> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAssignment update(EmployeeAssignment item) {
        if (item == null || item.getId() == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<EmployeeAssignment> update(List<EmployeeAssignment> items) {
        List<EmployeeAssignment> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        EmployeeAssignment item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(EmployeeAssignment item) {
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<EmployeeAssignment> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAdminId(Long id) {
        if (id == null) return 0;
        return dao.deleteByAdminId(id);
    }

    @Override
    public List<EmployeeAssignment> findByAdminId(Long id) {
        return dao.findByAdminId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByEmployeeId(Long id) {
        if (id == null) return 0;
        return dao.deleteByEmployeeId(id);
    }

    @Override
    public List<EmployeeAssignment> findByEmployeeId(Long id) {
        return dao.findByEmployeeId(id);
    }

    //----------------------------------------------------------
//----------------------------------------------------------
    @Autowired
    private EmployeeAssignmentDao dao;
    @Lazy
    @Autowired
    private AdminService adminService;
    @Lazy
    @Autowired
    private EmployeeService employeeService;
}