package org.bshg.librarysystem.repository.user;

import org.bshg.librarysystem.entity.core.user.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffDao extends JpaRepository<Staff, Long> {
    int deleteByIdIn(List<Long> ids);
}