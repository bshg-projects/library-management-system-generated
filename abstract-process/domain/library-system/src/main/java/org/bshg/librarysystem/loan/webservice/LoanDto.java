package org.bshg.librarysystem.loan.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.book.webservice.BookDto;
import org.bshg.librarysystem.client.webservice.ClientDto;
import org.bshg.librarysystem.employee.webservice.EmployeeDto;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanDto extends AuditBaseDto {
    public LoanDto() {
        super();
    }

    private String name;
    private BookDto book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private ClientDto client;
    private EmployeeDto employee;

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