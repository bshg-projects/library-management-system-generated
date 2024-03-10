package org.bshg.librarysystem.employeeassignment;

import jakarta.persistence.*;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.enums.AssignmentRoleTypeEnum;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;

import java.time.LocalDate;

/**
 * This Class is for Association between 'Employee' and 'Admin'
 * It extends AuditEntity to inherit auditing features.
 */
@Entity
@Table(name = "employeeassignment")
@SequenceGenerator(name = "employeeassignment_seq", sequenceName = "employeeassignment_seq", allocationSize = 1)
public class EmployeeAssignment extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeassignment_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private AssignmentRoleTypeEnum assignmentRole;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public EmployeeAssignment() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public AssignmentRoleTypeEnum getAssignmentRole() {
        return assignmentRole;
    }

    public void setAssignmentRole(AssignmentRoleTypeEnum value) {
        this.assignmentRole = value;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate value) {
        this.startDate = value;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate value) {
        this.endDate = value;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin value) {
        this.admin = value;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee value) {
        this.employee = value;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}