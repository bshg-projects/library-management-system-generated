package org.bshg.librarysystem.webservice.dto.user.admin;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.entity.enums.AssignmentRoleTypeEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeAssignmentDto {
private Long id;
private AssignmentRoleTypeEnum assignmentRole;
private LocalDate startDate;
private LocalDate endDate;
private boolean isActive;
private AdminDto admin;
private EmployeeDto employee;
public Long getId() {
return id;
}
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