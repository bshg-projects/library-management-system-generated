package org.bshg.librarysystem.entity.core.user.admin;
import org.bshg.librarysystem.entity.enums.AssignmentRoleTypeEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Employee' and 'Admin'
*/
@Entity
@Table(name="employeeassignment")
@SequenceGenerator(name = "employeeassignment_seq", sequenceName = "employeeassignment_seq", allocationSize = 1)
public class EmployeeAssignment {
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
}
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
if (object instanceof EmployeeAssignment employeeAssignment) {
return employeeAssignment.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}