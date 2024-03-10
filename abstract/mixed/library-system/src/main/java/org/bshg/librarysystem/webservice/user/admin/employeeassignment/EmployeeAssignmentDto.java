package org.bshg.librarysystem.webservice.user.admin.employeeassignment;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.entity.enums.AssignmentRoleTypeEnum;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.webservice.user.admin.admin.AdminDto;
import org.bshg.librarysystem.webservice.user.admin.employee.EmployeeDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeAssignmentDto extends AuditBaseDto {
    public EmployeeAssignmentDto() {
        super();
    }

    private AssignmentRoleTypeEnum assignmentRole;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;
    private AdminDto admin;
    private EmployeeDto employee;

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

    public AdminDto getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDto value) {
        this.admin = value;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto value) {
        this.employee = value;
    }
}