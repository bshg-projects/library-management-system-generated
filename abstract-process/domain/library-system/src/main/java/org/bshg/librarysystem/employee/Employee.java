package org.bshg.librarysystem.employee;
import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.book.Book;
import jakarta.persistence.*;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;
import java.time.*;
import java.util.*;
@Entity
@Table(name="employee")
public class Employee extends User {
private String firstName;
private String lastName;
private LocalDate dateOfBirth;
@OneToOne()
private Address address;
@Lob
private String biography;
private String position;
private String salary;
@OneToMany(mappedBy = "employee")
private List<Book> books;
@OneToMany(mappedBy = "employee")
private List<Loan> loans;
@OneToMany(mappedBy = "employee")
private List<EmployeeAssignment> employeeAssignment;
public Employee() {
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
public LocalDate getDateOfBirth() {
return dateOfBirth;
}
public void setDateOfBirth(LocalDate value) {
this.dateOfBirth = value;
}
public Address getAddress() {
return address;
}
public void setAddress(Address value) {
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
public List<Book> getBooks() {
return books;
}
public void setBooks(List<Book> value) {
this.books = value;
}
public List<Loan> getLoans() {
return loans;
}
public void setLoans(List<Loan> value) {
this.loans = value;
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