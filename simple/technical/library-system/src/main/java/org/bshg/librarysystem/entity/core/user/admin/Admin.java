package org.bshg.librarysystem.entity.core.user.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
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
        if (object instanceof Admin admin) {
            return admin.getId().equals(this.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}