package org.bshg.librarysystem.staff.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffDto extends UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String salary;

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
}