package org.bshg.librarysystem.repository.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDao extends Repository<Employee, Long> {
    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}