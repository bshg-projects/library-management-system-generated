package org.bshg.librarysystem.services.user.staff;

import org.bshg.librarysystem.entity.core.user.Staff;

import java.util.List;

public interface StaffService {
    Staff findById(Long id);

    List<Staff> findAllOptimized();

    List<Staff> findAll();

    Staff create(Staff item);

    List<Staff> create(List<Staff> item);

    Staff update(Staff item);

    List<Staff> update(List<Staff> item);

    void deleteById(Long id);

    void delete(Staff item);

    void delete(List<Staff> items);

    void deleteByIdIn(List<Long> ids);
}