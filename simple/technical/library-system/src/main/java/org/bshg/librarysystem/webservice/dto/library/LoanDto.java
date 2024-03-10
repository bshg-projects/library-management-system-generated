package org.bshg.librarysystem.webservice.dto.library;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.dto.content.BookDto;
import org.bshg.librarysystem.webservice.dto.user.ClientDto;
import org.bshg.librarysystem.webservice.dto.user.admin.EmployeeDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanDto {
    private Long id;
    private String name;
    private BookDto book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private ClientDto client;
    private EmployeeDto employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto value) {
        this.book = value;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate value) {
        this.loanDate = value;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate value) {
        this.returnDate = value;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto value) {
        this.client = value;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto value) {
        this.employee = value;
    }
}