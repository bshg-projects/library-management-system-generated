package org.bshg.librarysystem.admin;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AdminDao extends Repository<Admin, Long> {
}