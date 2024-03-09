package org.bshg.librarysystem.webservice.user.admin.employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;
import org.bshg.librarysystem.webservice.library.address.AddressDto;
import org.bshg.librarysystem.webservice.library.loan.LoanDto;
import org.bshg.librarysystem.webservice.user.admin.employeeassignment.EmployeeAssignmentDto;
import org.bshg.librarysystem.webservice.content.book.BookDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto extends UserDto {
private Long id;
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