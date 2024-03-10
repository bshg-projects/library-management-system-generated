package org.bshg.librarysystem.admin.services;

import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.AdminDao;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //--------------- FIND -------------------------------------
    public Admin findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Admin> findAll() {
        return dao.findAll();
    }

    public List<Admin> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Admin create(Admin item) {
        if (item == null) return null;
        Admin saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Admin> create(List<Admin> items) {
        List<Admin> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Admin update(Admin item) {
        if (item == null || item.getId() == null) return null;
        Admin saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Admin> update(List<Admin> items) {
        List<Admin> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Admin item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Admin item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Admin> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Admin item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
    public void createAssociatedList(Admin item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Admin::getEmployeeAssignment, EmployeeAssignment::setAdmin, employeeAssignmentService::create);
    }

    public void updateAssociatedList(Admin item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, employeeAssignmentService.findByAdminId(item.getId()),
                item.getEmployeeAssignment(), EmployeeAssignment::setAdmin,
                employeeAssignmentService::update,
                employeeAssignmentService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Admin item) {
        deleteAssociatedList(item);
    }

    public void deleteAssociatedList(Admin item) {
        employeeAssignmentService.deleteByAdminId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private AdminDao dao;
    @Lazy
    @Autowired
    private EmployeeAssignmentService employeeAssignmentService;
}