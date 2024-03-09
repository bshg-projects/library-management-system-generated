package org.bshg.librarysystem.admin.services;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import java.util.List;
public interface AdminService {
Admin findById(Long id);
List<Admin> findAllOptimized();
List<Admin> findAll();
Admin create(Admin item);
Admin edit(Admin item);
void deleteById(Long id);
void delete(Admin item);
void delete(List<Admin> items);
void deleteByIdIn(List<Long> ids);
}