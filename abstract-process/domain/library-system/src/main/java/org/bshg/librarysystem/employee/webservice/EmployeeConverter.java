package org.bshg.librarysystem.employee.webservice;

import org.bshg.librarysystem.address.webservice.AddressConverter;
import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employeeassignment.webservice.EmployeeAssignmentConverter;
import org.bshg.librarysystem.loan.webservice.LoanConverter;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter extends AbstractConverter<Employee, EmployeeDto> {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private AddressConverter addressConverter;
    @Autowired
    private LoanConverter loanConverter;
    @Autowired
    private EmployeeAssignmentConverter employeeAssignmentConverter;
    @Autowired
    private BookConverter bookConverter;
    private boolean address = true;
    private boolean books = true;
    private boolean loans = true;
    private boolean employeeAssignment = true;

    @Override
    protected void convertersConfig(boolean value) {
        this.loanConverter.setEmployee(value);
        this.employeeAssignmentConverter.setEmployee(value);
        this.bookConverter.setEmployee(value);
    }

    @Override
    protected Employee convertToItem(EmployeeDto dto) {
        var item = new Employee();
        userConverter.convertToChildItem(dto, item);
        item.setFirstName(dto.getFirstName());
        item.setLastName(dto.getLastName());
        item.setDateOfBirth(dto.getDateOfBirth());
        item.setAddress(addressConverter.toItem(dto.getAddress()));
        item.setBiography(dto.getBiography());
        item.setPosition(dto.getPosition());
        item.setSalary(dto.getSalary());
        item.setBooks(bookConverter.toItem(dto.getBooks()));
        item.setLoans(loanConverter.toItem(dto.getLoans()));
        item.setEmployeeAssignment(employeeAssignmentConverter.toItem(dto.getEmployeeAssignment()));
        return item;
    }

    @Override
    protected EmployeeDto convertToDto(Employee item) {
        var dto = new EmployeeDto();
        userConverter.convertToChildDto(item, dto);
        dto.setFirstName(item.getFirstName());
        dto.setLastName(item.getLastName());
        dto.setDateOfBirth(item.getDateOfBirth());
        dto.setAddress(address ? addressConverter.toDto(item.getAddress()) : null);
        dto.setBiography(item.getBiography());
        dto.setPosition(item.getPosition());
        dto.setSalary(item.getSalary());
        dto.setBooks(books ? bookConverter.toDto(item.getBooks()) : null);
        dto.setLoans(loans ? loanConverter.toDto(item.getLoans()) : null);
        dto.setEmployeeAssignment(employeeAssignment ? employeeAssignmentConverter.toDto(item.getEmployeeAssignment()) : null);
        return dto;
    }

    public void setAddress(boolean value) {
        this.address = value;
    }

    public void setBooks(boolean value) {
        this.books = value;
    }

    public void setLoans(boolean value) {
        this.loans = value;
    }

    public void setEmployeeAssignment(boolean value) {
        this.employeeAssignment = value;
    }

    public void setAddressConverter(AddressConverter value) {
        this.addressConverter = value;
    }

    public AddressConverter getAddressConverter() {
        return addressConverter;
    }

    public void setLoanConverter(LoanConverter value) {
        this.loanConverter = value;
    }

    public LoanConverter getLoanConverter() {
        return loanConverter;
    }

    public void setEmployeeAssignmentConverter(EmployeeAssignmentConverter value) {
        this.employeeAssignmentConverter = value;
    }

    public EmployeeAssignmentConverter getEmployeeAssignmentConverter() {
        return employeeAssignmentConverter;
    }

    public void setBookConverter(BookConverter value) {
        this.bookConverter = value;
    }

    public BookConverter getBookConverter() {
        return bookConverter;
    }
}