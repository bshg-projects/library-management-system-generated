package org.bshg.librarysystem.repository.user;

import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffDao extends Repository<Staff, Long> {
}