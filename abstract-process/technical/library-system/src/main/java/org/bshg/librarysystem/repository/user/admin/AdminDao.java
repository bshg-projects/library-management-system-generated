package org.bshg.librarysystem.repository.user.admin;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AdminDao extends Repository<Admin, Long> {
}