package org.bshg.librarysystem.staff.services;

import org.bshg.librarysystem.staff.Staff;

import java.util.List;

public interface StaffService {
    Staff findById(Long id);

    List<Staff> findAllOptimized();

    List<Staff> findAll();

    Staff create(Staff item);

    Staff edit(Staff item);

    void deleteById(Long id);

    void delete(Staff item);

    void delete(List<Staff> items);

    void deleteByIdIn(List<Long> ids);
}