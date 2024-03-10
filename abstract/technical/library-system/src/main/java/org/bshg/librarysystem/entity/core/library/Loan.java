package org.bshg.librarysystem.entity.core.library;

import jakarta.persistence.*;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;

import java.time.LocalDate;

@Entity
@Table(name = "loan")
@SequenceGenerator(name = "loan_seq", sequenceName = "loan_seq", allocationSize = 1)
public class Loan extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
    private Long id;
    private String name;
    @OneToOne()
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Loan() {
        super();
    }

    public Loan(Long id, String label) {
// constructor to get optimized fields
        this.id = id;
        this.name = label;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book value) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client value) {
        this.client = value;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee value) {
        this.employee = value;
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