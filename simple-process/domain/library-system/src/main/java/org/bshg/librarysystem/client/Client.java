package org.bshg.librarysystem.client;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.transaction.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "client")
    private List<Loan> loans;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "client")
    private List<Review> reviews;
    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions;
    @OneToMany(mappedBy = "client")
    private List<Payment> payments;

    public Client() {
        super();
        this.roles = new ArrayList<>();
        this.roles.add(RoleEnum.CLIENT.getRole());
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

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> value) {
        this.loans = value;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> value) {
        this.reservations = value;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> value) {
        this.reviews = value;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> value) {
        this.transactions = value;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> value) {
        this.payments = value;
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