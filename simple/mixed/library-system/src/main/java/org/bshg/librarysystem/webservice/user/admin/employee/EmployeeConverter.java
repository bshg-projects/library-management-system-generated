package org.bshg.librarysystem.webservice.user.admin.employee;

import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.webservice.content.book.BookConverter;
import org.bshg.librarysystem.webservice.library.address.AddressConverter;
import org.bshg.librarysystem.webservice.library.loan.LoanConverter;
import org.bshg.librarysystem.webservice.user.admin.employeeassignment.EmployeeAssignmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeConverter {
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

    protected void convertersConfig(boolean value) {
        this.loanConverter.setEmployee(value);
        this.employeeAssignmentConverter.setEmployee(value);
        this.bookConverter.setEmployee(value);
    }

    public final EmployeeDto toDto(Employee item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Employee toItem(EmployeeDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Employee> toItem(List<EmployeeDto> dtos) {
        if (dtos == null) return null;
        List<Employee> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<EmployeeDto> toDto(List<Employee> items) {
        if (items == null) return null;
        List<EmployeeDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

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