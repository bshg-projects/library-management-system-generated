package org.bshg.librarysystem.staff;
import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;
import java.time.*;
import java.util.*;
@Entity
@Table(name="staff")
public class Staff extends User {
private String firstName;
private String lastName;
private String position;
private String salary;
public Staff() {
super();
this.roles = new ArrayList<>();
this.roles.add(RoleEnum.EMPLOYEE.getRole());
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
public String getPosition() {
return position;
}
public void setPosition(String value) {
this.position = value;
}
public String getSalary() {
return salary;
}
public void setSalary(String value) {
this.salary = value;
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