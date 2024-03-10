package org.bshg.librarysystem.webservice.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffDto extends UserDto {
    public StaffDto() {
        super();
    }

    private String firstName;
    private String lastName;
    private String position;
    private String salary;

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