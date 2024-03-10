package org.bshg.librarysystem.reservation;

import jakarta.persistence.*;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.enums.ReservationStatusEnum;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "reservation_seq", sequenceName = "reservation_seq", allocationSize = 1)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    private Long id;
    private String name;
    @OneToOne()
    private Book book;
    private LocalDate reservationDate;
    @Enumerated(EnumType.STRING)
    private ReservationStatusEnum status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Reservation() {
        super();
    }

    public Reservation(Long id, String label) {
// constructor to get optimized fields
        this.id = id;
        this.name = label;
    }

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book value) {
        this.book = value;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate value) {
        this.reservationDate = value;
    }

    public ReservationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReservationStatusEnum value) {
        this.status = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client value) {
        this.client = value;
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