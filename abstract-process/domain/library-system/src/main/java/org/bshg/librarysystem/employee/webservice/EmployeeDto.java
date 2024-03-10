package org.bshg.librarysystem.employee.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.address.webservice.AddressDto;
import org.bshg.librarysystem.book.webservice.BookDto;
import org.bshg.librarysystem.employeeassignment.webservice.EmployeeAssignmentDto;
import org.bshg.librarysystem.loan.webservice.LoanDto;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto extends UserDto {
    public EmployeeDto() {
        super();
    }

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private AddressDto address;
    private String biography;
    private String position;
    private String salary;
    private List<BookDto> books;
    private List<LoanDto> loans;
    private List<EmployeeAssignmentDto> employeeAssignment;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate value) {
        this.dateOfBirth = value;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto value) {
        this.address = value;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String value) {
        this.biography = value;
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

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> value) {
        this.books = value;
    }

    public List<LoanDto> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDto> value) {
        this.loans = value;
    }

    public List<EmployeeAssignmentDto> getEmployeeAssignment() {
        return employeeAssignment;
    }

    public void setEmployeeAssignment(List<EmployeeAssignmentDto> value) {
        this.employeeAssignment = value;
    }
}