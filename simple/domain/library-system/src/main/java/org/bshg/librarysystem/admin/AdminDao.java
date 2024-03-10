package org.bshg.librarysystem.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminDao extends JpaRepository<Admin, Long> {
    int deleteByIdIn(List<Long> ids);
}