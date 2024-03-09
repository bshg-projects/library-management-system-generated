package org.bshg.librarysystem.entity.core.user.admin;
import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;
import java.time.*;
import java.util.*;
@Entity
@Table(name="admin")
public class Admin extends User {
private String firstName;
private String lastName;
@OneToMany(mappedBy = "admin")
private List<EmployeeAssignment> employeeAssignment;
public Admin() {
super();
this.roles = new ArrayList<>();
this.roles.add(RoleEnum.ADMIN.getRole());
}
public String getFirstName() {
return firstName;
}
public void setFirstName(String value) {
this.firstName = value;
}
public String getLastName() {
return lastName;
}
public void setLastName(String value) {
this.lastName = value;
}
public List<EmployeeAssignment> getEmployeeAssignment() {
return employeeAssignment;
}
public void setEmployeeAssignment(List<EmployeeAssignment> value) {
this.employeeAssignment = value;
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