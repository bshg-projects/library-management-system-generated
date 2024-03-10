package org.bshg.librarysystem.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffDao extends JpaRepository<Staff, Long> {
    int deleteByIdIn(List<Long> ids);
}