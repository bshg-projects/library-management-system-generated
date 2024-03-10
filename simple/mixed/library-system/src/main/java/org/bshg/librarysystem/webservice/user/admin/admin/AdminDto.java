package org.bshg.librarysystem.webservice.user.admin.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;
import org.bshg.librarysystem.webservice.user.admin.employeeassignment.EmployeeAssignmentDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminDto extends UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<EmployeeAssignmentDto> employeeAssignment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<EmployeeAssignmentDto> getEmployeeAssignment() {
        return employeeAssignment;
    }

    public void setEmployeeAssignment(List<EmployeeAssignmentDto> value) {
        this.employeeAssignment = value;
    }
}